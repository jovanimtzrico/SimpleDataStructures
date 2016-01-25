/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuradatos;

/**
 *
 * @author Jovani
 */
public class SearchName {
    String[] names;

    public void setNames() {
        this.names = new String[]{"Jovani","Stefanie","Alondra","Veronica","Gustavo","Edgar","Oscar","Jesus","Alain","Jovas"};
    }
    
    int search(String str){
        int position;
        for (position = 0;  position< 10; position++) {
            if (names[position] == str) {
                return position+1;
            }
        }
        return 0;
    }
}
