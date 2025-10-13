package interviews.tipico;

import java.util.*;


class InterviewProgram {
    public static void main(String[] args) {
        List<User> users = loadUsers();

        // todo populate the map
        Map<String, Collection<Address>> firstNameToAddress =  new HashMap<String, Collection<Address>>();
        for (User user: users) {
            firstNameToAddress.put(user.firstName, user.getAddresses());
        }
        System.out.println(firstNameToAddress.get("Sascha"));
    }

    private static List<User> loadUsers() {
        Address saschaAddressBerlin = new Address("Wilhelmstr 1", "Berlin", 10963);
        Address saschaAddressKarlsruhe = new Address("Alexaplatz 44", "Karlsruhe", 74233);
        final User sascha = new User("Sascha", "Zee", Arrays.asList(saschaAddressBerlin, saschaAddressKarlsruhe));

        Address stuttgart = new Address("Maxstr 3", "Stuttgart", 70152);
        User maxMustermann = new User("Max", "Mustermann", Arrays.asList(stuttgart));

        Address karlsruhe = new Address("Hauptstr 2", "Karlsruhe", 74222);
        User tipico = new User("Tipico", "Protech", Arrays.asList(karlsruhe));
        return Arrays.asList(sascha, maxMustermann, tipico);
    }

    private static final class User {
        private final String firstName;
        private final String surname;
        private final Set<Address> addresses;

        public User(String firstName, String surname, Collection<Address> addresses) {
            this.firstName = firstName;
            this.surname = surname;
            this.addresses = new HashSet(addresses);
        }

        public String getFirstName() {
            return firstName;
        }

        public String getSurname() {
            return surname;
        }

        public Collection<Address> getAddresses() {
            return new HashSet(addresses);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return firstName.equals(user.firstName) &&
                    surname.equals(user.surname) &&
                    addresses.equals(user.addresses);
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstName, surname, addresses);
        }
    }

    private static final class Address {
        private final String street;
        private final String city;
        private final Integer postalCode;

        public Address(String street, String city, Integer postalCode) {
            this.street = street;
            this.city = city;
            this.postalCode = postalCode;
        }

        public String getStreet() {
            return street;
        }

        public String getCity() {
            return city;
        }

        public Integer getPostalCode() {
            return postalCode;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Address address = (Address) o;
            return Objects.equals(street, address.street) &&
                    Objects.equals(city, address.city) &&
                    Objects.equals(postalCode, address.postalCode);
        }

        @Override
        public int hashCode() {
            return Objects.hash(street, city, postalCode);
        }

        @Override
        public String toString() {
            return "Address{" +
                    "street='" + street + '\'' +
                    ", city='" + city + '\'' +
                    ", postalCode=" + postalCode +
                    '}';
        }
    }
}