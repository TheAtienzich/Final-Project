import java.util.*;

public class Cliente extends Usuario{
    private String name;
    private String surname;
    private String address;
    private int phoneNumber;
    private String DNI;
    private String postalCode;
    private String province;
    private String locality;
    private CreditCard creditCardClient;
    private List<Order> ordersClient;

    public Cliente(String name, String surname, String email, String passWord) {
        super(email, passWord, name);
        this.surname = surname;
        this.ordersClient = new List<Order>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Order> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Order order) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Order> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Order> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public Order get(int index) {
                return null;
            }

            @Override
            public Order set(int index, Order element) {
                return null;
            }

            @Override
            public void add(int index, Order element) {

            }

            @Override
            public Order remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Order> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Order> listIterator(int index) {
                return null;
            }

            @Override
            public List<Order> subList(int fromIndex, int toIndex) {
                return List.of();
            }
        };

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CreditCard getCreditCardClient() {
        return creditCardClient;
    }

    public void setCreditCardClient(CreditCard creditCardClient) {
        this.creditCardClient = creditCardClient;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}
