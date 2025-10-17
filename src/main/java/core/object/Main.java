package core.object;

public class Main {
    /*Главная аксиома: если хэшкоды разные, то и объекты гарантированно разные
     * Если хэшкоды равны, то объекты необязательно равны
     * */
    public static void main(String[] args) {
        // Объекты называются равными, когда их типы и поля одинаковы
        Client client1 = new Client(1, "Nick", "Just Nick");
        Client client2 = new Client(1, "Nick", "Just Nick");
//        Client client2 = new Client(2, "Mike", "Just Mike");

        System.out.println(client1.hashCode());
        System.out.println(client2.hashCode());

        //Можно упомянуть, что при печати объекта как раз таки вызывается toString()
        System.out.println(client1);
        System.out.println(client2);
    }
}
