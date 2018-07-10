package data;

import android.provider.BaseColumns;

public class UsersContract {

    public static abstract class UsersEntry implements BaseColumns {
        public static final String TABLE_NAME ="Users";

        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String TELEPHONE = "telephone";
        public static final String TYPE = "type";
        public static final String PASS = "pass";
        public static final String EMAIL = "email";
    }
}