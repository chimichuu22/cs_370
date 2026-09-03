


public class play{
    public static void main(String[] args)
        {
        
    
            System.out.println("Player 1 = X");
            System.out.println("Player 2 = O");

            printBoard();
        }
        
        public static void printBoard()
        {
            char[][] board = {
                {'_','_', '_','_','_','_','_','_','_','_'},
                {'|',' ',' ', '|',' ',' ', '|',' ',' ', '|'},

                {'-','-', '-','-','-','-','-','-','-','-'},
                {'|',' ',' ', '|',' ',' ', '|',' ',' ', '|'},

                {'-','-', '-','-','-','-','-','-','-','-'},
                {'|',' ',' ', '|',' ',' ', '|',' ',' ', '|'},
                {'-','-', '-','-','-','-','-','-','-','-'},
            };


         

            for(int i = 0; i < board.length; i++)
            {
                for(int j = 0; j < board[i].length; j++)
                {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }

        }

    private void printStatus(int player)
    {

    }

    private void gameStatus()
    {

    }

    private void printSymbol(int column, int value)
    {

    }

    private void validmove()
    {

    }
}
    
    