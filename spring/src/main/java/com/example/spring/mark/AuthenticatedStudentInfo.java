package com.example.spring.mark;

public class AuthenticatedStudentInfo {
    static boolean isAuthenticated = false;
    static int authenticatedId = -1;

    public static boolean isAuthenticated() {
        return isAuthenticated;
    }

    public static int getAuthenticatedId() {
        return authenticatedId;
    }

    public static void setAuthenticatedId(int authenticatedId) {
        AuthenticatedStudentInfo.authenticatedId = authenticatedId;
    }

    public static void setIsAuthenticated(boolean isAuthenticated) {
        AuthenticatedStudentInfo.isAuthenticated = isAuthenticated;
    }
}
