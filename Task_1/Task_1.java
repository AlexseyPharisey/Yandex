package yandex1;

public class step1 {
    public static void main(String[] args){
        Answer myAnswer = new Answer("ABCBC", "BBACA");
        for(int i = 0; i < myAnswer.Correct.length; i++){
            myAnswer.Correct[i] = '0';
            myAnswer.Answer[i] = '0';
        }
        myAnswer.CheakWord(myAnswer.word_S, myAnswer.word_Q);
        myAnswer.Output(myAnswer.Answer);
    }
}

class Answer{
    char[] word_S;
    char[] word_Q;
    char[] Correct;
    char[] Answer;
    public int CorrectControl = 0;

    public Answer(String a, String b){
        this.word_S = a.toCharArray();
        this.word_Q = b.toCharArray();
        this.Correct = new char[word_S.length];
        this.Answer = new char[word_S.length];
    }
    void CheakWord(char[] S, char[] Q){
        int Cheak = 0;
        for(int i = 0; i<Q.length; i++){
            for (int x = 0; x<Correct.length; x++){
                if(Q[i] == Correct[x]) Cheak = 1;
            }
            for(int j = 0; j<S.length; j++){
                if((Q[i] == S[j]) && i==j){
                    Answer[i] = 'c';
                    Correct[CorrectControl] = Q[i];
                    CorrectControl++;
                    break;
                }
                if((Q[i] == S[j]) && i!=j && Cheak == 0){
                    Answer[i] = 'p';
                    Correct[CorrectControl] = Q[i];
                    CorrectControl++;
                    break;
                }
            }
            Cheak = 0;
        }
    }
    void Output(char[] a){
        for (int i = 0; i<a.length; i++){
            if(a[i]=='c') System.out.println("correct");
            if(a[i]=='p') System.out.println("present");
            if(a[i]=='0') System.out.println("absent");
        }
    }
}
