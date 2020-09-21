/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pif.desktop.Classes;

/**
 *
 * @author arthu
 */
public class USER_LOGADO {

    private static String COLAB_NOME = new String();
    private static String COLAB_SOBRENOME = new String();
    private static String COLAB_CPF = new String();
    private static String COLAB_RG = new String();
    private static String COLAB_ESTADO= new String();
    private static String COLAB_CEP = new String();
    private static String COLAB_CIDADE = new String();
    private static String COLAB_BAIRRO = new String();
    private static String COLAB_LOGRAD = new String();
    private static String COLAB_LOGRAD_NUM = new String();
    private static String COLAB_LOGRAD_COMP = new String();
    private static String COLAB_DATA_NASCIMENTO = new String();
    private static String COLAB_CONTATO_EMAIL = new String();
    private static String COLAB_CONTATO_NUM_TEL1 = new String();
    private static String COLAB_CONTATO_NUM_TEL2 = new String();
    private static boolean COLAB_IS_TEC;
    private static boolean COLAB_IS_GERENTE;
    
    /**
     * @return the COLAB_NOME
     */
    public static String getCOLAB_NOME() {
        return COLAB_NOME;
    }

    /**
     * @param aCOLAB_NOME the COLAB_NOME to set
     */
    public static void setCOLAB_NOME(String aCOLAB_NOME) {
        COLAB_NOME = aCOLAB_NOME;
    }

    /**
     * @return the COLAB_SOBRENOME
     */
    public static String getCOLAB_SOBRENOME() {
        return COLAB_SOBRENOME;
    }

    /**
     * @param aCOLAB_SOBRENOME the COLAB_SOBRENOME to set
     */
    public static void setCOLAB_SOBRENOME(String aCOLAB_SOBRENOME) {
        COLAB_SOBRENOME = aCOLAB_SOBRENOME;
    }

    /**
     * @return the COLAB_CPF
     */
    public static String getCOLAB_CPF() {
        return COLAB_CPF;
    }

    /**
     * @param aCOLAB_CPF the COLAB_CPF to set
     */
    public static void setCOLAB_CPF(String aCOLAB_CPF) {
        COLAB_CPF = aCOLAB_CPF;
    }

    /**
     * @return the COLAB_RG
     */
    public static String getCOLAB_RG() {
        return COLAB_RG;
    }

    /**
     * @param aCOLAB_RG the COLAB_RG to set
     */
    public static void setCOLAB_RG(String aCOLAB_RG) {
        COLAB_RG = aCOLAB_RG;
    }

    /**
     * @return the COLAB_ESTADO
     */
    public static String getCOLAB_ESTADO() {
        return COLAB_ESTADO;
    }

    /**
     * @param aCOLAB_ESTADO the COLAB_ESTADO to set
     */
    public static void setCOLAB_ESTADO(String aCOLAB_ESTADO) {
        COLAB_ESTADO = aCOLAB_ESTADO;
    }

    /**
     * @return the COLAB_CEP
     */
    public static String getCOLAB_CEP() {
        return COLAB_CEP;
    }

    /**
     * @param aCOLAB_CEP the COLAB_CEP to set
     */
    public static void setCOLAB_CEP(String aCOLAB_CEP) {
        COLAB_CEP = aCOLAB_CEP;
    }

    /**
     * @return the COLAB_CIDADE
     */
    public static String getCOLAB_CIDADE() {
        return COLAB_CIDADE;
    }

    /**
     * @param aCOLAB_CIDADE the COLAB_CIDADE to set
     */
    public static void setCOLAB_CIDADE(String aCOLAB_CIDADE) {
        COLAB_CIDADE = aCOLAB_CIDADE;
    }

    /**
     * @return the COLAB_BAIRRO
     */
    public static String getCOLAB_BAIRRO() {
        return COLAB_BAIRRO;
    }

    /**
     * @param aCOLAB_BAIRRO the COLAB_BAIRRO to set
     */
    public static void setCOLAB_BAIRRO(String aCOLAB_BAIRRO) {
        COLAB_BAIRRO = aCOLAB_BAIRRO;
    }

    /**
     * @return the COLAB_LOGRAD
     */
    public static String getCOLAB_LOGRAD() {
        return COLAB_LOGRAD;
    }

    /**
     * @param aCOLAB_LOGRAD the COLAB_LOGRAD to set
     */
    public static void setCOLAB_LOGRAD(String aCOLAB_LOGRAD) {
        COLAB_LOGRAD = aCOLAB_LOGRAD;
    }

    /**
     * @return the COLAB_LOGRAD_NUM
     */
    public static String getCOLAB_LOGRAD_NUM() {
        return COLAB_LOGRAD_NUM;
    }

    /**
     * @param aCOLAB_LOGRAD_NUM the COLAB_LOGRAD_NUM to set
     */
    public static void setCOLAB_LOGRAD_NUM(String aCOLAB_LOGRAD_NUM) {
        COLAB_LOGRAD_NUM = aCOLAB_LOGRAD_NUM;
    }

    /**
     * @return the COLAB_LOGRAD_COMP
     */
    public static String getCOLAB_LOGRAD_COMP() {
        return COLAB_LOGRAD_COMP;
    }

    /**
     * @param aCOLAB_LOGRAD_COMP the COLAB_LOGRAD_COMP to set
     */
    public static void setCOLAB_LOGRAD_COMP(String aCOLAB_LOGRAD_COMP) {
        COLAB_LOGRAD_COMP = aCOLAB_LOGRAD_COMP;
    }
    
       /**
     * @return the COLAB_DATA_NASCIMENTO
     */
    public static String getCOLAB_DATA_NASCIMENTO() {
        return COLAB_DATA_NASCIMENTO;
    }

    /**
     * @param aCOLAB_DATA_NASCIMENTO the COLAB_DATA_NASCIMENTO to set
     */
    public static void setCOLAB_DATA_NASCIMENTO(String aCOLAB_DATA_NASCIMENTO) {
        COLAB_DATA_NASCIMENTO = aCOLAB_DATA_NASCIMENTO;
    }
    
        /**
     * @return the COLAB_CONTATO_EMAIL
     */
    public static String getCOLAB_CONTATO_EMAIL() {
        return COLAB_CONTATO_EMAIL;
    }

    /**
     * @param aCOLAB_CONTATO_EMAIL the COLAB_CONTATO_EMAIL to set
     */
    public static void setCOLAB_CONTATO_EMAIL(String aCOLAB_CONTATO_EMAIL) {
        COLAB_CONTATO_EMAIL = aCOLAB_CONTATO_EMAIL;
    }

    /**
     * @return the COLAB_CONTATO_NUM_TEL1
     */
    public static String getCOLAB_CONTATO_NUM_TEL1() {
        return COLAB_CONTATO_NUM_TEL1;
    }

    /**
     * @param aCOLAB_CONTATO_NUM_TEL1 the COLAB_CONTATO_NUM_TEL1 to set
     */
    public static void setCOLAB_CONTATO_NUM_TEL1(String aCOLAB_CONTATO_NUM_TEL1) {
        COLAB_CONTATO_NUM_TEL1 = aCOLAB_CONTATO_NUM_TEL1;
    }

    /**
     * @return the COLAB_CONTATO_NUM_TEL2
     */
    public static String getCOLAB_CONTATO_NUM_TEL2() {
        return COLAB_CONTATO_NUM_TEL2;
    }

    /**
     * @param aCOLAB_CONTATO_NUM_TEL2 the COLAB_CONTATO_NUM_TEL2 to set
     */
    public static void setCOLAB_CONTATO_NUM_TEL2(String aCOLAB_CONTATO_NUM_TEL2) {
        COLAB_CONTATO_NUM_TEL2 = aCOLAB_CONTATO_NUM_TEL2;
    }
    
        /**
     * @return the COLAB_IS_TEC
     */
    public static boolean isCOLAB_TEC() {
        return COLAB_IS_TEC;
    }

    /**
     * @param aCOLAB_IS_TEC the COLAB_IS_TEC to set
     */
    public static void setCOLAB_TEC(boolean aCOLAB_IS_TEC) {
        COLAB_IS_TEC = aCOLAB_IS_TEC;
    }

    /**
     * @return the COLAB_IS_GERENTE
     */
    public static boolean isCOLAB_GERENTE() {
        return COLAB_IS_GERENTE;
    }

    /**
     * @param aCOLAB_IS_GERENTE the COLAB_IS_GERENTE to set
     */
    public static void setCOLAB_GERENTE(boolean aCOLAB_IS_GERENTE) {
        COLAB_IS_GERENTE = aCOLAB_IS_GERENTE;
    }
}
