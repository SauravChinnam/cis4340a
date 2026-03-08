import java.lang.reflect.Field;


public class R16_SEC05_J {

    static class Secret {
        private String key = "12345";

        public String getKey() {
            return key;
        }


        public void setKey(String newKey) {

            this.key = newKey;
        }
    }

    public static void main(String[] args) throws Exception {
        Secret secure = new Secret();
        System.out.println("Original key: " + secure.getKey());

        secure.setKey("67890");
        System.out.println("Modified key: " + secure.getKey());
    }
}
