package pif.desktop;
/**
 * Copyright (C) 2020 EduApps (Eduardo Procópio Gomez)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * @author <a href="EduApps">https://eduapps-cdg.github.io/about</a>
 */
public class NetworkUtils {
    /**
     * cria uma url preparada para ser executada
     * @param sqlMethod Exemplo: "GET", "POST" 
     * @param table Exemplo: "test", "clientes"
     * @param args Exemplo:
     * new String[] {
     *  "pica=grande",
     *  "usuário=tals"
     * }
     * @return 
     */
    public static String generateConnectionURL(String sqlMethod,String table, String[] args) {
        String juntas = String.join("&", args);
        return "https://projeto-integrador-final.000webhostapp.com/" + sqlMethod.toLowerCase() + "/" + table.toLowerCase() + ".php?" + juntas.toLowerCase();
    }
}
