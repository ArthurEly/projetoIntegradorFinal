package br.com.senac.pif_mobile;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

import br.com.senac.pif_mobile.util.Linux;
import br.com.senac.pif_mobile.util.NetworkUtils;
import br.com.senac.pif_mobile.util.TimeUtils;

/**
 * Classe contendo informações de orçamento (GETTER E SETTER COM CONEXÃO A NET)
 */
public class Oramento /*IH*/ {
    ArrayList<Informações> lista = new ArrayList<Informações>();

    public Oramento(int osnum) throws JSONException {
        String result = Linux.curl(null, NetworkUtils.urlizeGet(NetworkUtils.DB_TABLE_ORCAMENTO,NetworkUtils.DB_COL_OS_NUMERO, osnum + ""));
        JSONArray js = new JSONArray(result);

        for (int XXX = 0; XXX < js.length(); XXX++) {
            JSONObject x = js.getJSONObject(XXX);
            Date data = new Date(
                    TimeUtils.getYearBySQL(x.getString(NetworkUtils.DB_COL_ORCAMENTO_DATA)),
                    TimeUtils.getMonthBySQL(x.getString(NetworkUtils.DB_COL_ORCAMENTO_DATA)),
                    TimeUtils.getDayBySQL(x.getString(NetworkUtils.DB_COL_ORCAMENTO_DATA)),
                    TimeUtils.getHoursBySQL(x.getString(NetworkUtils.DB_COL_ORCAMENTO_DATA)),
                    TimeUtils.getMinutesBySQL(x.getString(NetworkUtils.DB_COL_ORCAMENTO_DATA)),
                    TimeUtils.getSecondsBySQL(x.getString(NetworkUtils.DB_COL_ORCAMENTO_DATA))
            );

            lista.add(new Informações(
                    Double.parseDouble(x.getString(NetworkUtils.DB_COL_ORCAMENTO_PRECO_PECAS)),
                    x.getString(NetworkUtils.DB_COL_ORCAMENTO_DESCRICAO_PECAS),
                    Double.parseDouble(x.getString(NetworkUtils.DB_COL_ORCAMENTO_PRECO_SERVICOS)),
                    x.getString(NetworkUtils.DB_COL_ORCAMENTO_DESCRICAO_SERVICOS),
                    data
            ));
        }

    }

    public Informações getInfo(int posição) {
        return lista.get(posição);
    }

    public static class Informações {
        private double price = 0.00;
        private String name = "Dildo Rosa";
        private double service = 0.00;
        private String description = "Presentinho pra você!";
        private Date date;

        public Informações(double price, String name, double service, String description, Date date) {
            this.price = price;
            this.name = name;
            this.service = service;
            this.description = description;
            this.date = date;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getService() {
            return service;
        }

        public void setService(double service) {
            this.service = service;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }
    }

    //DONE
}
