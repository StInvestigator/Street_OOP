package code.street.enums;

public enum HospitalDepartment {
    CARDIOLOGY,          // Кардиология
    NEUROLOGY,           // Неврология
    PEDIATRICS,          // Педиатрия
    ONCOLOGY,            // Онкология
    ORTHOPEDICS,         // Ортопедия
    GYNECOLOGY,          // Гинекология
    DERMATOLOGY,         // Дерматология
    SURGERY,             // Хирургия
    PSYCHIATRY,          // Психиатрия
    EMERGENCY,           // Скорая помощь
    OPHTHALMOLOGY,       // Офтальмология
    RADIOLOGY,           // Радиология
    DENTISTRY,           // Стоматология
    ENDOCRINOLOGY,       // Эндокринология
    INTERNAL_MEDICINE;   // Терапевтическое отделение

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase().replace('_', ' ');
    }
}