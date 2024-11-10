package code.street.utils;

public class MyJsonParser {
    public static String extractValue(String json, String key) {
        String searchKey = "\"" + key + "\"";
        int startIndex = json.indexOf(searchKey) + searchKey.length();
        startIndex = json.indexOf(":", startIndex) + 1;

        int endIndex;
        if (json.charAt(startIndex) == '"') { // Строковое значение
            startIndex++;
            endIndex = json.indexOf("\"", startIndex);
        } else { // Числовое значение
            endIndex = json.indexOf(",", startIndex);
            if (endIndex == -1) { // Если последний элемент
                endIndex = json.indexOf("}", startIndex);
            }
        }

        return json.substring(startIndex, endIndex).trim();
    }

    public static String[] extractArray(String json, String key) {
        String searchKey = "\"" + key + "\":";
        int startIndex = json.indexOf(searchKey) + searchKey.length();
        int endIndex = json.indexOf("]", startIndex) + 1; // Найти конец массива
        String arrayJson = json.substring(startIndex, endIndex).trim();

        arrayJson = arrayJson.substring(1, arrayJson.length() - 1).trim(); // Убрать [ и ]

        if (arrayJson.isEmpty()) {
            return new String[0]; // Вернуть пустой массив, если нет элементов
        }

        String[] items = arrayJson.split("\",\\s*\""); // Разделение по ", "

        // Удалить начальные и конечные кавычки у каждого элемента
        for (int i = 0; i < items.length; i++) {
            items[i] = items[i].replaceAll("^\"|\"$", "");
        }

        return items;
    }
}
