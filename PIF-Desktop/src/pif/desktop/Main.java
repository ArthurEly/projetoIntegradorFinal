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
package pif.desktop;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import pif.desktop.TELAS.JLogin;
import pif.desktop.TELAS.JMain;

/**
 * @author <a href="EduApps">https://eduapps-cdg.github.io/about</a>
 */
public class Main {

    public static void main(String[] args) {
        JFrame principal = new JMain();
        principal.setVisible(true);

        //tenta esperar 2 segundos
        try {
            Thread.sleep(2500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        principal.dispose();
        principal = new JLogin();
        principal.setVisible(true);
    }
}
