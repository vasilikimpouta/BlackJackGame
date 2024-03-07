public enum Cards {

    ASSO_KARDIA(11, Colors.HEART),
    ASSO_SPATHI(11, Colors.SPADE),
    ASSO_ROMVO(11, Colors.DIAMOND),
    ASSO_MPASTOUNI(11, Colors.CLUB),

    DUO_KARDIA(2, Colors.HEART),
    DUO_SPATHI(2, Colors.SPADE),
    DUO_ROMVO(2, Colors.DIAMOND),
    DUO_MPASTOUNI(2, Colors.CLUB),

    TRIA_KARDIA(3, Colors.HEART),
    TRIA_SPATHI(3, Colors.SPADE),
    TRIA_ROMVO(3, Colors.DIAMOND),
    TRIA_MPASTOUNI(3, Colors.CLUB),


    TESSERA_KARDIA(4, Colors.HEART),
    TESSERA_SPATHI(4, Colors.SPADE),
    TESSERA_ROMVO(4, Colors.DIAMOND),
    TESSERA_MPASTOUNI(4, Colors.CLUB),


    PENTE_KARDIA(5, Colors.HEART),
    PENTE_SPATHI(5, Colors.SPADE),
    PENTE_ROMVO(5, Colors.DIAMOND),
    PENTE_MPASTOUNI(5, Colors.CLUB),


    EXI_KARDIA(6, Colors.HEART),
    EXI_SPATHI(6, Colors.SPADE),
    EXI_ROMVO(6, Colors.DIAMOND),
    EXI_MPASTOUNI(6, Colors.CLUB),


    EFTA_KARDIA(7, Colors.HEART),
    EFTA_SPATHI(7, Colors.SPADE),
    EFTA_ROMVO(7, Colors.DIAMOND),
    EFTA_MPASTOUNI(7, Colors.CLUB),


    OKTO_KARDIA(8, Colors.HEART),
    OKTO_SPATHI(8, Colors.SPADE),
    OKTO_ROMVO(8, Colors.DIAMOND),
    OKTO_MPASTOUNI(8, Colors.CLUB),

    NINE_KARDIA(9, Colors.HEART),
    NINE_SPATHI(9, Colors.SPADE),
    NINE_ROMVO(9, Colors.DIAMOND),
    NINE_MPASTOUNI(9, Colors.CLUB),

    TEN_KARDIA(10, Colors.HEART),
    TEN_SPATHI(10, Colors.SPADE),
    TEN_ROMVO(10, Colors.DIAMOND),
    TEN_MPASTOUNI(10, Colors.CLUB),

    VALE_KARDIA(10, Colors.HEART),
    VALE_SPATHI(10, Colors.SPADE),
    VALE_ROMVO(10, Colors.DIAMOND),
    VALE_MPASTOUNI(10, Colors.CLUB),

    DAMA_KARDIA(10, Colors.HEART),
    DAMA_SPATHI(10, Colors.SPADE),
    DAMA_ROMVO(10, Colors.DIAMOND),
    DAMA_MPASTOUNI(10, Colors.CLUB),


    RIGAS_KARDIA(10, Colors.HEART),
    RIGAS_SPATHI(10, Colors.SPADE),
    RIGAS_ROMVO(10, Colors.DIAMOND),
    RIGAS_MPASTOUNI(10, Colors.CLUB);


    private final int numberValue;
    private final Colors color;


    private Cards(int numberValue, Colors color) {
        this.numberValue = numberValue;
        this.color = color;
    }

    public int getNumberValue() {
        return numberValue;
    }
    public Colors getColor() {
        return color;
    }
    public boolean isAssos() {
        //return this == ASSO_KARDIA || this == ASSO_MPASTOUNI || this == ASSO_ROMVO || this == ASSO_SPATHI;
        return this.numberValue == 11;
    }

    public boolean isFigoura() {
        return  this == DAMA_MPASTOUNI ||
                this == DAMA_SPATHI ||
                this == DAMA_ROMVO ||
                this == DAMA_KARDIA ||
                this == VALE_MPASTOUNI ||
                this == VALE_SPATHI ||
                this == VALE_ROMVO ||
                this == VALE_KARDIA ||
                this == RIGAS_MPASTOUNI ||
                this == RIGAS_SPATHI ||
                this == RIGAS_ROMVO ||
                this == RIGAS_KARDIA;
    }

    enum Colors {
        CLUB,
        HEART,
        SPADE,
        DIAMOND;
    }

}
