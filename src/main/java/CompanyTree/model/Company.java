package CompanyTree.model;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Ramin on 6/14/2017.
 */

public class Company {
    @Id
    private String id;
    @NotNull
    private String name;
    private List<String> parentCompanies;
    private List<String> subsidiaries;

    public Company() {
    }

    public Company(String id, String name, List<String> parentCompanies, List<String> subsidiaries) {
        this.id = id;
        this.name = name;
        this.parentCompanies = parentCompanies;
        this.subsidiaries = subsidiaries;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getParentCompanies() {
        return parentCompanies;
    }

    public void setParentCompanies(List<String> parentCompanies) {
        this.parentCompanies = parentCompanies;
    }

    public List<String> getSubsidiaries() {
        return subsidiaries;
    }

    public void setSubsidiaries(List<String> subsidiaries) {
        this.subsidiaries = subsidiaries;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", parentCompanies=" + parentCompanies +
                ", subsidiaries=" + subsidiaries +
                '}';
    }
}
