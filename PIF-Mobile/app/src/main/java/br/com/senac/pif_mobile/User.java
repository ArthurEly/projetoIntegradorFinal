package br.com.senac.pif_mobile;

import org.jetbrains.annotations.Nullable;

import java.util.Date;

/**
 * a classe User é um bando de getters e setters com as informações do usuário
 *
 * @author Eduardo P. Gomez
 */
public class User {
    private int ID = 0;
    private PersonaType personaType;
    private String name;
    private String email;
    private Location location;
    private Date birth;
    private String password;

    public User(int id, PersonaType type, String name, String email, Location location, Date birth, String password) {
        this.ID = id;
        this.personaType = type;
        this.name = name;
        this.email = email;
        this.location = location;
        this.birth = birth;
        this.password = password;
    }

    public User(PersonaType type, String name, String email, Location location, Date birth, String password) {
        this.personaType = type;
        this.name = name;
        this.email = email;
        this.location = location;
        this.birth = birth;
        this.password = password;
    }

    public static class PersonaType {
        private String cpf;
        private String cnpj;
        private boolean operator = false;

        public PersonaType(boolean operator, String cpf_cnpj) {
            this.operator = operator;

            if (operator) {
                this.cpf = "NULL";
                this.cnpj = cpf_cnpj;
            } else {
                this.cpf = cpf_cnpj;
                this.cnpj = "NULL";
            }
        }

        public PersonaType(String cpf) {
            this.operator = false;
            this.cpf = cpf;
        }

        public String getCpf() {
            return cpf;
        }

        public void setCpf(String cpf) {
            this.operator = false;
            this.cpf = cpf;
            this.cnpj = "NULL";
        }

        public String getCnpj() {
            return cnpj;
        }

        public void setCnpj(String cnpj) {
            this.operator = true;
            this.cpf = "NULL";
            this.cnpj = cnpj;
        }

        public boolean isOperator() {
            return operator;
        }
    }

    public static class Location {
        private String city;
        private String state;
        private String country;
        private String street;
        private int number = 0;
        private String cep;

        public Location() {
            this.city = "NULL";
            this.state = "NULL";
            this.country = "NULL";
            this.street = "NULL";
            this.number = 0;
            this.cep = "000000-000";
        }

        public Location(@Nullable String city,@Nullable String state,@Nullable String country,@Nullable String street,@Nullable int number,@Nullable String cep) {
            if (city == null) {
                this.city = "NULL";
            } else {
                this.city = city;
            }

            if (state == null) {
                this.state = "NULL";
            } else {
                this.state = state;
            }

            if (country == null) {
                this.country = "NULL";
            } else {
                this.country = country;
            }

            if (street == null) {
                this.street = "NULL";
            } else {
                this.street = street;
            }

            if (cep == null) {
                this.cep = "000000-000";
            } else {
                this.cep = cep;
            }

            this.number = 0;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getCep() {
            return cep;
        }

        public void setCep(String cep) {
            this.cep = cep;
        }
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public PersonaType getPersonaType() {
        return personaType;
    }

    public void setPersonaType(PersonaType personaType) {
        this.personaType = personaType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return this.location.city;
    }

    public void setCity(String city) {
        this.location.city = city;
    }

    public String getState() {
        return location.state;
    }

    public void setState(String state) {
        this.location.state = state;
    }

    public String getCountry() {
        return location.country;
    }

    public void setCountry(String country) {
        this.location.country = country;
    }

    public String getStreet() {
        return location.street;
    }

    public void setStreet(String street) {
        this.location.street = street;
    }

    public int getNumber() {
        return location.number;
    }

    public void setNumber(int number) {
        this.location.number = number;
    }

    public String getCep() {
        return location.cep;
    }

    public void setCep(String cep) {
        this.location.cep = cep;
    }

    public String getCpf() {
        return personaType.cpf;
    }

    public void setCpf(String cpf) {
        this.personaType.operator = false;
        this.personaType.cpf = cpf;
        this.personaType.cnpj = "NULL";
    }

    public String getCnpj() {
        return personaType.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.personaType.operator = true;
        this.personaType.cpf = "NULL";
        this.personaType.cnpj = cnpj;
    }

    public boolean isOperator() {
        return  this.personaType.isOperator();
    }

    public String getBirthSQL() {
        int yyyy = birth.getYear();
        int mm = birth.getMonth();
        int dd = birth.getDay();

        return yyyy + "-" + mm + "-" + dd;
    }
}
