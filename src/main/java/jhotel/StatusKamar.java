package jhotel;
        /**
        * Enumeration class StatusKamar - write a description of the enum class here
        * @author (your name here)
+ * @version (version number or date here)
+ */
        public enum StatusKamar
{
            Status_1("Booked"), Status_2("Processed"), Status_3("Vacant") ;
            private String status;
            StatusKamar(String status){
                this.status=status;
            }

            public String status(){
             return status;
            }

            public String toString()
            {
                return status;
            }
        }

        enum Status
{
        }