package CompanyTree.db;

import CompanyTree.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ramin on 6/14/2017.
 */

@Service
public class CompanyMongoClient implements ICompanyDatabaseConnectionClient {

    @Autowired
    private CompanyRepository cmpyRepository;

    @Override
    public List<Company> getAllCompanies() {
        return cmpyRepository.findAll();
    }

    @Override
    public Company addCompany(Company company) {
        return cmpyRepository.save(company);
    }

    @Override
    public Company getCompanyById(String id) {
        return cmpyRepository.findById(id);
    }

    @Override
    public Company removeCompany(String companyId) {
        Company company = cmpyRepository.findById(companyId);
        cmpyRepository.deleteById(companyId);
        return company;
    }
}
