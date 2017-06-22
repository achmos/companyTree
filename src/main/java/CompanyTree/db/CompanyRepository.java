package CompanyTree.db;

import CompanyTree.model.Company;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Ramin on 6/14/2017.
 */

public interface CompanyRepository extends MongoRepository<Company,String> {
    public Company findById(String id);
    public Long deleteById(String id);
}