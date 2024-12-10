package at.htlhl.httpclientdemo;

public class Example {
    public static void main(String[] args) {
        User user1 = new User.UserBuilder("Lokesh", "Gupta")
                .age(13)
                .phone("1234567")
                .address("Springfield ?")
                .build();

        System.out.println(user1);

        User user2 = new User.UserBuilder("Lokesh", "Gupta")
                .age(52)
                .phone("007")
                // no address
                .build();
        System.out.println(user2);

        User user3 = new User.UserBuilder("Lokesh", "Gupta")
                // no age
                // no phone
                // no address
                .build();
        System.out.println(user3);
    }
}
