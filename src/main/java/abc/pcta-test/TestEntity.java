package abc.pcta_test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TestEntity {
    
    @Id @GeneratedValue
    private String id;
    private String value;
    
    public TestEntity() {}
    
    public TestEntity(String value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return "TestEntity[id=" + id + ", value=" + value + "]";
    }

    public String getId() {
        return id;
    }
    public void setI(String id) {
        this.id = id;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    
}