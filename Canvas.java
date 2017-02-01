public class Canvas {
    private char[][] canvas;
    private int width;
    private int height;
    private boolean canvasExists;

    public Canvas(){
        canvasExists = false;
    }

    private void validate(int w1, int h1, int w2, int h2){
        if(!canvasExists) {
            JOptionPane.showMessageDialog(null, "You must create a canvas first. The input file is invalid.");
            System.exit(1);
        }
        if(w1 < 1 || w1 > width || h1 < 1 || h1 > height || w2 < 1 || w2 > width || h2 < 1 || h2 > height){
            JOptionPane.showMessageDialog(null, "Invalid dimensions. Exiting.");
            System.exit(1);
        }
    }

    public void createCanvas(int width, int height){
        this.height = height;
        this.width = width;
        canvas = new char[height+2][];
        for(int i = 0; i < height; i++){
            canvas[i] = new char[width+2];
            for(int j = 1; j < width + 1; j++){
                canvas[i][j] = ' ';
            }
        }
        for(int i = 0; i < width + 2; i++){
            canvas[0][i] = '-';
            canvas[height-1][i] = '-';
        }
        for(int i = 1; i < height + 1; i++){
            canvas[i][0] = '|';
            canvas[i][width + 1] = '|';
        }
        canvasExists = true;
    }

    public void line(int w1, int h1, int w2, int h2){
        validate(w1, h1, w2, h2);
        if(w1 == w2){
            for(int i = h1; i <= h2; i++){
                canvas[i][w1] = 'x';
            }
        }
        else if(h1 == h2){
            for(int i = w1; i <= w2; i++){
                canvas[h1][i] = 'x';
            }
        }
    }

    public void rectangle(int w1, int h1, int w2, int h2){
        validate(w1, h1, w2, h2);
        for(int i = w1; i <= w2; i++){
            canvas[h1][i] = 'x';
            canvas[h2][i] = 'x';
        }
        for(int i = h1; i <= h2; i++){
            canvas[i][w1] = 'x';
            canvas[i][w2] = 'x';
        }
    }

    public void bubbleFill(int w, int h, char c){
        if(canvas[h][w] == ' ' && h < height+2 && h > 0 && w < width+2 && w > 0){
            canvas[h][w] = c;
            bubbleFill(w-1, h, c);
            bubbleFill(w+1, h, c);
            bubbleFill(w, h-1, c);
            bubbleFill(w, h+1, c);
        }
        else if(h >= height+2 || h <= 0 || w >= width+2 || w <= 0){
            System.out.println("Invalid dimensions.");
        }
    }
}