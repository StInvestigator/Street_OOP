package code.street.enums;

public enum SchoolType {
    GENERAL_EDUCATION,  // Обычная общеобразовательная школа
    GYMNASIUM,          // Гимназия
    LYCEUM,             // Лицей
    TECHNICAL_SCHOOL;    // Техникум

    @Override
    public String toString() {
        // Преобразуем название в более читаемый формат
        return name().charAt(0) + name().substring(1).toLowerCase().replace('_', ' ');
    }
}