/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Enrique
 */
@RestController
@RequestMapping("/gato")
public class GatoController {

    @RequestMapping(value = "/juego", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    String gato(@RequestParam("a1") String a1, @RequestParam("a2") String a2, @RequestParam("a3") String a3,
            @RequestParam("b1") String b1, @RequestParam("b2") String b2, @RequestParam("b3") String b3,
            @RequestParam("c1") String c1, @RequestParam("c2") String c2, @RequestParam("c3") String c3) {
        String[][] matris = new String[3][3];
        boolean breik = false;
        int i, j;
        int[][] matrizBuena = new int[3][3];
        JSONObject retorno = new JSONObject();

        matris[0][0] = a2;
        matris[0][1] = a2;
        matris[0][2] = a3;
        matris[1][0] = b1;
        matris[1][1] = b2;
        matris[1][2] = b3;
        matris[2][0] = c1;
        matris[2][1] = c2;
        matris[2][2] = c3;

        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                String gatito = matris[i][j];
                if (gatito.equals(" ")) {
                    matrizBuena[0][0] = 0;
                } else if (gatito.equals("X")) {
                    matrizBuena[0][0] = 1;
                } else if (gatito.equals("O")) {
                    matrizBuena[0][0] = 2;
                }
            }
        }
        for (int k = 0; k < 3; k++) {
            if ((matrizBuena[k][0] + matrizBuena[k][1] + matrizBuena[k][2]) == 3) {
                //gano x
            } else if ((matrizBuena[k][0] + matrizBuena[k][1] + matrizBuena[k][2]) == 6) {
                //gano o     
            }
        }
        for (int k = 0; k < 3; k++) {
            if ((matrizBuena[0][k] + matrizBuena[1][k] + matrizBuena[2][k]) == 3) {
                //gano x
            } else if ((matrizBuena[0][k] + matrizBuena[0][k] + matrizBuena[0][k]) == 6) {
                //gano o     
            }
        }

        if ((matrizBuena[0][2] + matrizBuena[1][1] + matrizBuena[2][0]) == 3) {
            //gano x
        } else if ((matrizBuena[2][0] + matrizBuena[1][1] + matrizBuena[2][0]) == 6) {
            //gano o     

        }
        if ((matrizBuena[0][0] + matrizBuena[1][1] + matrizBuena[2][2]) == 3) {
            //gano x
        } else if ((matrizBuena[0][0] + matrizBuena[1][1] + matrizBuena[2][2]) == 6) {
            //gano o      
        }
        
        for (i = 0; i < 3 && !breik; i++) {
            for (j = 0; j < 3; j++) {
                if (matris[i][j].equals(" ")) {
                    retorno.put("x", i);
                    retorno.put("y", j);
                    breik = true;
                    break;
                }
            }
        }
        System.out.println();
        return retorno.toString();
    }
}
