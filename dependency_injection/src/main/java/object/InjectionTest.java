package object;

import java.util.*;

public class InjectionTest {

    private String[] array_;
    private Department[] array2_;
    private List<String> list_;
    private Set<String> set_;
    private Map<String, Integer> map_;
    private Properties properties_;


    public String[] getArray_() {
        return array_;
    }

    public void setArray_(String[] array_) {
        this.array_ = array_;
    }

    public Department[] getArray2_() {
        return array2_;
    }

    public void setArray2_(Department[] array2_) {
        this.array2_ = array2_;
    }

    public List<String> getList_() {
        return list_;
    }

    public void setList_(List<String> list_) {
        this.list_ = list_;
    }

    public Set<String> getSet_() {
        return set_;
    }

    public void setSet_(Set<String> set_) {
        this.set_ = set_;
    }

    public Map<String, Integer> getMap_() {
        return map_;
    }

    public void setMap_(Map<String, Integer> map_) {
        this.map_ = map_;
    }

    public Properties getProperties_() {
        return properties_;
    }

    public void setProperties_(Properties properties_) {
        this.properties_ = properties_;
    }

    @Override
    public String toString() {
        return "InjectionTest{" +
                "array_=" + Arrays.toString(array_) +
                ", array2_=" + Arrays.toString(array2_) +
                ", list_=" + list_ +
                ", set_=" + set_ +
                ", map_=" + map_ +
                ", properties_=" + properties_ +
                '}';
    }
}
