package by.guzypaul.medicinecentre.entity;

public enum Role {
    ADMIN,
    MODERATOR,
    USER,
    DOCTOR;

    /*public static Role findRole(String roleName) {
        return Arrays.stream(Role.values())
                .filter(currentRole -> currentRole.equals(roleName.toUpperCase()))
                .findFirst()
                .orElse(USER); // todo USER???
    }*/
}
