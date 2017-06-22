package CompanyTree;
/**
 * Created by Ramin on 6/14/2017.
 */

import CompanyTree.db.ICompanyDatabaseConnectionClient;
import CompanyTree.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CompanyTreeController {

    @Autowired
    private ICompanyDatabaseConnectionClient dbConnection;

    @RequestMapping(method=RequestMethod.GET,value="/company")
    public List<Company> getAllCompanies() {
        TemporaryLogging.outputDebugText("Request for all companies via REST endpoint");
        return dbConnection.getAllCompanies();
    }

    //TODO: incorrect body response error response
    //TODO: What to do when parent company or subsidiary is not in the database already.
    @RequestMapping(method=RequestMethod.POST, value="/company/")
    public ResponseEntity<Company> addCompany(@Valid @RequestBody Company company) {
        TemporaryLogging.outputDebugText("Request to create company via REST endpoint");
        TemporaryLogging.outputDebugText(String.format("Company object recieved: %s",company.toString()));
        Company cmp = dbConnection.addCompany(company);
        return new ResponseEntity<>(cmp, HttpStatus.CREATED);
    }

    @RequestMapping(method=RequestMethod.GET,value="/company/{companyId}")
    public ResponseEntity<Company> getCompanyById(@PathVariable String companyId) {
        TemporaryLogging.outputDebugText("Request for company by ID via REST endpoint");
        Company cmp = this.getCompanyFromDatabase(companyId);
        return new ResponseEntity<>(cmp, HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/company/{companyId}")
    public ResponseEntity<Company> deleteCompany(@PathVariable String companyId) {
        Company cmp = dbConnection.removeCompany(companyId);
        if (cmp == null) {
            throw new IllegalArgumentException(String.format("Company with ID %s does not exist", companyId));
        }
        return new ResponseEntity<>(cmp, HttpStatus.OK);
    }

    //FIXME: create appropriate response body for empty list of companies
    @RequestMapping(method=RequestMethod.GET,value="/company/{companyId}/subsidiaries")
    public ResponseEntity<List<String>> getSubsidiariesOfCompany(@PathVariable String companyId) {
        TemporaryLogging.outputDebugText("Request for a company's subsidiaries via REST endpoint");
        Company cmp = this.getCompanyFromDatabase(companyId);
        return new ResponseEntity<>(cmp.getSubsidiaries(),HttpStatus.OK);
    }

    //FIXME: create appropriate response body for empty list of companies
    @RequestMapping(method=RequestMethod.GET,value="/company/{companyId}/parents")
    public ResponseEntity<List<String>> getParentsOfCompany(@PathVariable String companyId) {
        TemporaryLogging.outputDebugText("Request for a company's parent companies via REST endpoint");
        Company cmp = this.getCompanyFromDatabase(companyId);
        return new ResponseEntity<>(cmp.getParentCompanies(),HttpStatus.OK);
    }

    private Company getCompanyFromDatabase(String companyId) {
        Company cmp = dbConnection.getCompanyById(companyId);
        if (cmp == null) {
            throw new IllegalArgumentException(String.format("Company with ID %s does not exist", companyId));
        } else {
            return cmp;
        }
    }
//-----------------------------------------------------------------------------

    public void addParentToCompany(String company) {

    }

    public void removeParentFromCompany(String company) {

    }

    public void addSubsidiaryToCompany(String company) {

    }

    public void removeSubsidiaryFromCompany(String company) {

    }
}
