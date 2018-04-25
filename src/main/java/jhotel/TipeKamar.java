package jhotel;
/**
  * Enumeration class TipeKamar - write a description of the enum class here
  *
  * @author (your name here)
  * @version (version number or date here)
  */
public enum TipeKamar
{
            Tipe_1("Single"), Tipe_2("Double"), Tipe_3("Premium") ;
            private String tipe;
            TipeKamar(String tipe){
                this.tipe=tipe;
            }

            public String tipe(){
             return tipe;
            }
            public String toString()
            {
                return tipe;
            }
        }