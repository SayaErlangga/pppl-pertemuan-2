import java.util.ArrayList;
public class Wallet {
    String owner;
    ArrayList<String> listKartu;
    ArrayList<Integer> listUangKoin;
    ArrayList<Integer> listUangLembaran;


    public Wallet() {
        listKartu = new ArrayList<>();
        listUangKoin = new ArrayList<>();
        listUangLembaran = new ArrayList<>();
    }

    public Wallet(String owner){
        this.owner = owner;
    }

    public String setOwner(){
        return owner;
    }

    public void addCard(String cardName){
        this.listKartu.add(cardName);
    }

    public String removeCard(String cardName){
        boolean takenCard = this.listKartu.remove(cardName);
        if (takenCard){
            return cardName;
        }
        throw new Error("Kartu tidak tersedia");
    }

    public void deposit(int totalMoney){
        if (totalMoney < 0){
            throw new Error("Uang yang dimasukkan tidak boleh kurang dari 0");
        }

        if (totalMoney >= 1000){
            listUangLembaran.add(totalMoney);
        } else {
            listUangKoin.add(totalMoney);
        }
    }

    public int withdraw(int totalMoney){
        boolean isUangLembaranTaken = this.listUangLembaran.remove(
                Integer.valueOf(totalMoney));
        if (isUangLembaranTaken){
            return totalMoney;
        }
        boolean isUangKoinTaken = this.listUangKoin.remove(
                Integer.valueOf(totalMoney));
        if (isUangKoinTaken){
            return totalMoney;
        }
        throw new Error("Uang tidak tersedia didalam dompet");
    }

    public int tampilkanUang(){
        int totalUang = 0;
        for (Integer uang: listUangKoin){
            totalUang += uang;
        }
        for (Integer uang: listUangLembaran){
            totalUang += uang;
        }
        return totalUang;
    }
}
