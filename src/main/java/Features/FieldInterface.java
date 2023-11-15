/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Features;

import Elementos.Celula;

/**
 *
 * @author pedro
 */
public abstract  interface FieldInterface {
    public void insertMatrix(Celula newElement, int posRow, int posCol );
    public int CheckBombAround(int row, int col);
    public void AddPosition(int row, int col);
    public int lengthClicked();
     public void setIsVazio(Boolean isVazio);
     public int[] ClickedElement(int position);
     public void fillMatrix();
     public void fillBombs();
     public void insertBombAround(int row, int col);
    
}
