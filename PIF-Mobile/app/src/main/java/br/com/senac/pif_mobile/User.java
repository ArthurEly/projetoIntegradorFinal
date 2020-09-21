package br.com.senac.pif_mobile;

import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

import br.com.senac.pif_mobile.util.NetworkUtils;

/**
 * a classe User é um bando de getters e setters com as informações do usuário
 *
 * Esta classe contém subclasses usadas internamente
 *
 * @author Eduardo P. Gomez
 */
public class User {
    private int ID = 0;
    private String name;
    private String surname;
    private ArrayList<Contact> contact;
    private Location location;
    private Date birth;
    private String password;
    private String RG;

    /**
     * Cria um usuário
     *
     * @param id
     * @param name
     * @param surname
     * @param contacts
     * @param location
     * @param birth
     * @param password
     */
    public User(int id, String name, String surname, ArrayList<Contact> contacts, Location location, Date birth, String password) {
        this.ID = id;
        this.name = name;
        this.surname = surname;
        this.contact = contacts;
        this.location = location;
        this.birth = birth;
        this.password = password;
    }

    /**
     * Converte um usuário JSON em User
     *
     * @param json_user
     * @param json_contacts
     */
    public User(String json_user, String json_contacts) {

    }

    /**
     * Uma classe usada internamente para contatos
     */
    public static class Contact {
        private PersonaType personaType;
        private String email;
        private String cell1;
        private String cell2;

        /**
         * Cria um contato
         *
         * @param type
         * @param email
         * @param cell1
         * @param cell2
         */
        public Contact(PersonaType type, String email, String cell1, @Nullable String cell2) {
            this.personaType = type;
            this.email = email;
            this.cell1 = cell1;
            this.cell2 = cell2;
        }

        /**
         * Converte um contato JSON para um contato em classe
         *
         * @param json
         */
        public Contact(String json) {
            //esses valores serão mostrados caso haja um erro no try abaixo:
            PersonaType pt;
            String email = "null@null.com";
            String cell1 = "00000000000000";
            String cell2 = "0";

            try {
                JSONObject j = new JSONObject(json);
                email = j.getString(NetworkUtils.DB_COL_CONTATO_EMAIL);
                cell1 = j.getString(NetworkUtils.DB_COL_CONTATO_TEL1);
                cell2 = j.getString(NetworkUtils.DB_COL_CONTATO_TEL2);
                pt = new PersonaType(j.getString(NetworkUtils.DB_COL_CONTATO_CPF));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        public String getCpf() {
            return personaType.cpf;
        }

        //seta um cpf e remove o cnpj, pois um cliente não pode ter os 2.
        public void setCpf(String cpf) {
            this.personaType.operator = false;
            this.personaType.cpf = cpf;
            this.personaType.cnpj = "NULL";
        }

        public String getCnpj() {
            return personaType.cnpj;
        }

        //seta um cnpj e remove o cpf, pois um cliente não pode ter os 2.
        public void setCnpj(String cnpj) {
            this.personaType.operator = true;
            this.personaType.cpf = "NULL";
            this.personaType.cnpj = cnpj;
        }

        public boolean isOperator() {
            return  this.personaType.isOperator();
        }

        public PersonaType getPersonaType() {
            return personaType;
        }

        public void setPersonaType(PersonaType personaType) {
            this.personaType = personaType;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getCell1() {
            return cell1;
        }

        public void setCell1(String cell1) {
            this.cell1 = cell1;
        }

        public String getCell2() {
            return cell2;
        }

        public void setCell2(String cell2) {
            this.cell2 = cell2;
        }
    }

    /**
     *  Uma classe usada internamente para definir o tipo de pessoa (jurídica ou física)
     */
    public static class PersonaType {
        private String cpf;
        private String cnpj;
        private boolean operator = false;

        /**
         * cria um contexto para informação de pessoa
         *
         * @param operator se for true é pessoa juridica, se não é pessoa física
         * @param cpf_cnpj se operador for true essa string se torna cnpj se  não, cpf
         */
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

    /**
     * Uma classe com todas as informações de localização do cliente <s>para futuros assaltos</s>
     */
    public static class Location {
        private String city;
        private String state;
        private String country;
        private String street;
        private int number = 0;
        private String cep;
        private String logrator;

        /**
         * cria uma localização desconhecida
         */
        public Location() {
            this.city = "NULL";
            this.state = "NULL";
            this.country = "NULL";
            this.street = "NULL";
            this.number = 0;
            this.cep = "000000-000";
        }

        /**
         * Croia uma localização, não necessáriamente conhecida (pode ser localização aproximada)
         *
         * @param city
         * @param state
         * @param country
         * @param street
         * @param number
         * @param cep
         * @param logrator
         */
        public Location(@Nullable String city,@Nullable String state,@Nullable String country,@Nullable String street,@Nullable int number,@Nullable String cep, @Nullable  String logrator) {
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

            if (logrator == null) {
                this.logrator = "NULL";
            } else {
                this.logrator = logrator;
            }

            this.number = number;
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

        public String getLogrator() {
            return logrator;
        }

        public void setLogrator(String logrator) {
            this.logrator = logrator;
        }
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact getContact(int index) {
        return contact.get(index);
    }

    public void setContact(int index, Contact contact) {
        this.contact.set(index,contact);
    }

    public void addContact(Contact contact) { this.contact.add(contact); }

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

    /**
     * converte java.util.Date para uma data no padrão sql
     *
     * @return uma string com formato SQL
     */
    public String getBirthSQL() {
        int yyyy = birth.getYear();
        int mm = birth.getMonth();
        int dd = birth.getDay();

        return yyyy + "-" + mm + "-" + dd;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }
}
