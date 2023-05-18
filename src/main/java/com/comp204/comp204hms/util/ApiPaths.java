package com.comp204.comp204hms.util;

public class ApiPaths {

    private static final String BASE_PATH = "/api";

    public static final class DepartmentCtrl{
        public static final String CTRL = BASE_PATH + "/departments";
    }

    public static final class RoomCtrl{
        public static final String CTRL = BASE_PATH + "/rooms";
    }

    public static final class DoctorCtrl{
        public static final String CTRL = BASE_PATH + "/doctors";
    }

    public static final class PatientCtrl{
        public static final String CTRL = BASE_PATH + "/patients";
    }
}
