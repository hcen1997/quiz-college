package xyz.hcen.quizweb.constant;

public class Constant {

    public enum Status {
        SUCCESS(1, "成功"),
        ERROR(-1, "错误");

        private int key;
        private String value;

        Status(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }

    public enum LoginStatus {
        SUCCESS(1, "success","登录成功"),
        ERROR(-1, "error","登录失败"),
        USERNAMEERROR(2,"usernameError","用户名不存在"),
        PASSWORDERROR(3,"passwordError","密码错误");

        private int key;
        private String value;
        private String body;

        LoginStatus(int key, String value,String body) {
            this.key = key;
            this.value = value;
            this.body  = body;
        }

        public int getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }
    }
}