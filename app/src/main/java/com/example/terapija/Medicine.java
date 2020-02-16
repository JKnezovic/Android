package com.example.terapija;

public class Medicine {
    public String title, description, important_information, before_taking, how_to_use, side_effects;

    public Medicine() {
    }

    public Medicine(String title, String description, String important_information, String before_taking, String how_to_use, String side_effects) {
        this.title = title;
        this.description = description;
        this.important_information = important_information;
        this.before_taking = before_taking;
        this.how_to_use = how_to_use;
        this.side_effects = side_effects;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImportant_information() {
        return important_information;
    }

    public void setImportant_information(String important_information) {
        this.important_information = important_information;
    }

    public String getBefore_taking() {
        return before_taking;
    }

    public void setBefore_taking(String before_taking) {
        this.before_taking = before_taking;
    }

    public String getHow_to_use() {
        return how_to_use;
    }

    public void setHow_to_use(String how_to_use) {
        this.how_to_use = how_to_use;
    }

    public String getSide_effects() {
        return side_effects;
    }

    public void setSide_effects(String side_effects) {
        this.side_effects = side_effects;
    }
}
