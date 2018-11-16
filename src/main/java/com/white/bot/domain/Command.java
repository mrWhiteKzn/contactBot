package com.white.bot.domain;

import java.util.Objects;

/**
 * An command used by Bot. Incoming String is going to be parsed to the command.
 */
public class Command {
    private String type;
    private String name;
    private String phone;
    private String company;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Command command = (Command) o;
        return Objects.equals(type, command.type) &&
                Objects.equals(name, command.name) &&
                Objects.equals(phone, command.phone) &&
                Objects.equals(company, command.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name, phone, company);
    }

    @Override
    public String toString() {
        return "Command{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
