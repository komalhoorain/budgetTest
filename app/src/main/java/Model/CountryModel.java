package Model;

/**
 * Created by Komal UETian on 8/27/2016.
 */
public class CountryModel {
    private String name;
    private String code;
    public CountryModel()
    {}
    public CountryModel(CountryModel obj)
    {
        this.setCode(obj.getCode());
        this.setName(obj.getName());
    }
    public CountryModel(String name,String code)
    {
        this.setName(name);
        this.setCode(code);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
