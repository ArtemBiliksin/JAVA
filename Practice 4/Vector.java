public class Vector {
    private int dimension;
    private double [] coordinates;

    Vector(double[] coordinates){
        dimension = coordinates.length;
        this.coordinates = coordinates;
    }

    Vector(Vector v, int dim){
        if(dim < v.dimension){
            double[] tmpCoordinates = new double[dim];
            for(int i = 0; i < dim; i++){
                tmpCoordinates[i] = v.getComponent(i);
            }
            this.dimension = dim;
            this.coordinates = tmpCoordinates;
        }
        else{
            this.dimension = v.dimension;
            this.coordinates = v.coordinates;
        }
    }

    // размерность
    public int dimension(){
        return dimension;
    }

    // возвращает компоненту вектора
    double getComponent(int i){
        return coordinates[i];
    }

    // скалярное произведение векторов
    double scalar(Vector v){
        double scalar = 0;
        for(int i = 0; i < Math.min(this.dimension, v.dimension); i++){
            scalar += this.getComponent(i) * v.getComponent(i);
        }
        return scalar;
    }

    // длина вектора
    double len(){
        return Math.sqrt(this.scalar(this));
    }

    // умножение вектора на скаляр
    Vector multiply(double factor){
        double[] tmpCoordinates = new double[this.dimension];
        for(int i = 0; i < tmpCoordinates.length; i++){
            tmpCoordinates[i] = this.getComponent(i) * factor;
        }
        return new Vector(tmpCoordinates);
    }

    // сложение двух векторов
    Vector add(Vector v){
        int dim = Math.min(this.dimension, v.dimension);
        double[] tmpCoordinates = new double[dim];
        for(int i = 0; i < dim; i++){
            tmpCoordinates[i] = this.getComponent(i) + v.getComponent(i);
        }
        return new Vector(tmpCoordinates);
    }

    // вычитание векторов
    Vector sub(Vector v){
       return this.add(v.multiply(-1));
    }

    // возвращает проекцию вектора на вектор v по формуле
    // пр_{\vec b} \vec a = \frac{(\vec a, \vec b)}{|\vec b|},
    // (\vec a, \vec b) -- скалярное произведение
    double pr(Vector v){
        return this.scalar(v) / v.len();
    }
}
