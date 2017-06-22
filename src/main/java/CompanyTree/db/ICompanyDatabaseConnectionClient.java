package CompanyTree.db;

import CompanyTree.model.Company;

import java.util.List;

/**
 * Created by Ramin on 6/14/2017.
 */
public interface ICompanyDatabaseConnectionClient {
    public List<Company> getAllCompanies();
    public Company addCompany(Company company);
    public Company getCompanyById(String id);
    public Company removeCompany(String id);
//    public void addParentToCompany(String company);
//    public void removeParentFromCompany(String company);
//    public void addSubsidiaryToCompany(String company);
//    public void removeSubsidiaryFromCompany(String company);
}
