import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by esokolyanskaya on 04/11/2015.
 */
public class CashClass {

    Map<Integer, Item> dataMap = new HashMap<>();
    int key = 0;
    Date now = new Date();
    int max = 2147483647;

    CashClass() {}

    CashClass(int max) {
        this.max = max;
    }


    public void addData(String userData) {
        dataMap.put(key, new Item(userData));
        key++;
    }

    public void addData(String userData, Date expTime) throws Exception {
        if (key == max) {
            throw new Exception("Size Limitation");
        }
        else if (expTime.after(now)) {
            dataMap.put(key, new Item(userData, expTime));
            key++;
        }

    }

    public String getUserData(int key) {
        cleanObsoleteItems();
        return dataMap.get(key).getUserData();
    }

    void cleanObsoleteItems() {
        for (int i=0; i< dataMap.size(); i++) {
            if (dataMap.get(i).getExpTime().before(new Date()))
                dataMap.remove(i);
        }
    }

}

class Item {

    private Date expTime = null;
    String userData;

    Item(String userData) {
        this.userData = userData;
    }

    Item(String userData, Date expTime) {
        this.userData = userData;
        this.expTime = expTime;
    }

    public String getUserData() {
        return userData;
    }

    public Date getExpTime() {
        return expTime;
    }
}
