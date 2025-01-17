PGDMP          !        	        |           Original    12.17    12.17 W    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16544    Original    DATABASE     �   CREATE DATABASE "Original" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'French_France.1252' LC_CTYPE = 'French_France.1252';
    DROP DATABASE "Original";
                postgres    false            �            1259    16673 
   appartenir    TABLE     Y   CREATE TABLE public.appartenir (
    id_p integer NOT NULL,
    id_o integer NOT NULL
);
    DROP TABLE public.appartenir;
       public         heap    postgres    false            �            1259    16587    consultation    TABLE     �   CREATE TABLE public.consultation (
    id_c integer NOT NULL,
    nom_p character varying(128) NOT NULL,
    date_c character(32) NOT NULL,
    resultat_examen character varying(128) NOT NULL,
    nom_m character varying(128) NOT NULL
);
     DROP TABLE public.consultation;
       public         heap    postgres    false            �            1259    16593 	   consulter    TABLE     s   CREATE TABLE public.consulter (
    id_p integer NOT NULL,
    id_c integer NOT NULL,
    id_m integer NOT NULL
);
    DROP TABLE public.consulter;
       public         heap    postgres    false            �            1259    16715    contenir    TABLE     i   CREATE TABLE public.contenir (
    id_o integer NOT NULL,
    nom_med character varying(128) NOT NULL
);
    DROP TABLE public.contenir;
       public         heap    postgres    false            �            1259    16772    fournir    TABLE     V   CREATE TABLE public.fournir (
    id_m integer NOT NULL,
    id_o integer NOT NULL
);
    DROP TABLE public.fournir;
       public         heap    postgres    false            �            1259    16865    seq_medecin    SEQUENCE     t   CREATE SEQUENCE public.seq_medecin
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.seq_medecin;
       public          postgres    false            �            1259    16560    medecin    TABLE     c  CREATE TABLE public.medecin (
    id_m integer DEFAULT nextval('public.seq_medecin'::regclass) NOT NULL,
    nom_m character varying(128) NOT NULL,
    specialite_m character varying(128) NOT NULL,
    adresse_m character varying(128),
    numtel_m character varying(128),
    horraire_consultation time without time zone,
    numero_ordonance integer
);
    DROP TABLE public.medecin;
       public         heap    postgres    false    218            �            1259    16549 
   medicament    TABLE     �   CREATE TABLE public.medicament (
    nom_med character varying(128) NOT NULL,
    forme_med character varying(128) NOT NULL,
    dose_med character varying(128) NOT NULL,
    prise_med character varying(128) NOT NULL
);
    DROP TABLE public.medicament;
       public         heap    postgres    false            �            1259    16867    seq_ordonance    SEQUENCE     v   CREATE SEQUENCE public.seq_ordonance
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.seq_ordonance;
       public          postgres    false            �            1259    16575 
   ordonnance    TABLE     �   CREATE TABLE public.ordonnance (
    id_o integer DEFAULT nextval('public.seq_ordonance'::regclass) NOT NULL,
    instruction_ordon character varying(128),
    date_o date,
    liste_med character varying(128) NOT NULL
);
    DROP TABLE public.ordonnance;
       public         heap    postgres    false    219            �            1259    16863    seq_patient    SEQUENCE     t   CREATE SEQUENCE public.seq_patient
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.seq_patient;
       public          postgres    false            �            1259    16569    patient    TABLE       CREATE TABLE public.patient (
    id_p integer DEFAULT nextval('public.seq_patient'::regclass) NOT NULL,
    nom_p character varying(200) NOT NULL,
    dtns_p date NOT NULL,
    sexe_p character(2) NOT NULL,
    poids_p integer,
    adresse_p character varying(128)
);
    DROP TABLE public.patient;
       public         heap    postgres    false    217            �            1259    16601    prendre    TABLE     Y   CREATE TABLE public.prendre (
    id_rdv smallint NOT NULL,
    id_p integer NOT NULL
);
    DROP TABLE public.prendre;
       public         heap    postgres    false            �            1259    16636    prise    TABLE     W   CREATE TABLE public.prise (
    id_rdv smallint NOT NULL,
    id_m integer NOT NULL
);
    DROP TABLE public.prise;
       public         heap    postgres    false            �            1259    16869 
   seq_rdvous    SEQUENCE     s   CREATE SEQUENCE public.seq_rdvous
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 !   DROP SEQUENCE public.seq_rdvous;
       public          postgres    false            �            1259    16581    rdvous    TABLE     �   CREATE TABLE public.rdvous (
    nom_p character varying(128),
    nom_m character varying(128),
    id_rdv smallint DEFAULT nextval('public.seq_rdvous'::regclass) NOT NULL,
    lieu_rdv character(32),
    date_rdv timestamp without time zone
);
    DROP TABLE public.rdvous;
       public         heap    postgres    false    220            �            1259    16779    resultat    TABLE     W   CREATE TABLE public.resultat (
    id_c integer NOT NULL,
    id_o integer NOT NULL
);
    DROP TABLE public.resultat;
       public         heap    postgres    false            �            1259    16861    seq_consultation    SEQUENCE     y   CREATE SEQUENCE public.seq_consultation
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.seq_consultation;
       public          postgres    false            �            1259    16547    seq_incrementer    SEQUENCE     x   CREATE SEQUENCE public.seq_incrementer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.seq_incrementer;
       public          postgres    false    208            �           0    0    seq_incrementer    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.seq_incrementer OWNED BY public.consultation.id_c;
          public          postgres    false    202            �
           2604    16590    consultation id_c    DEFAULT     p   ALTER TABLE ONLY public.consultation ALTER COLUMN id_c SET DEFAULT nextval('public.seq_incrementer'::regclass);
 @   ALTER TABLE public.consultation ALTER COLUMN id_c DROP DEFAULT;
       public          postgres    false    208    202    208            �          0    16673 
   appartenir 
   TABLE DATA           0   COPY public.appartenir (id_p, id_o) FROM stdin;
    public          postgres    false    212   �b       |          0    16587    consultation 
   TABLE DATA           S   COPY public.consultation (id_c, nom_p, date_c, resultat_examen, nom_m) FROM stdin;
    public          postgres    false    208   �b       }          0    16593 	   consulter 
   TABLE DATA           5   COPY public.consulter (id_p, id_c, id_m) FROM stdin;
    public          postgres    false    209   d       �          0    16715    contenir 
   TABLE DATA           1   COPY public.contenir (id_o, nom_med) FROM stdin;
    public          postgres    false    213   d       �          0    16772    fournir 
   TABLE DATA           -   COPY public.fournir (id_m, id_o) FROM stdin;
    public          postgres    false    214   ;d       x          0    16560    medecin 
   TABLE DATA           z   COPY public.medecin (id_m, nom_m, specialite_m, adresse_m, numtel_m, horraire_consultation, numero_ordonance) FROM stdin;
    public          postgres    false    204   Xd       w          0    16549 
   medicament 
   TABLE DATA           M   COPY public.medicament (nom_med, forme_med, dose_med, prise_med) FROM stdin;
    public          postgres    false    203   �d       z          0    16575 
   ordonnance 
   TABLE DATA           P   COPY public.ordonnance (id_o, instruction_ordon, date_o, liste_med) FROM stdin;
    public          postgres    false    206   �e       y          0    16569    patient 
   TABLE DATA           R   COPY public.patient (id_p, nom_p, dtns_p, sexe_p, poids_p, adresse_p) FROM stdin;
    public          postgres    false    205   �e       ~          0    16601    prendre 
   TABLE DATA           /   COPY public.prendre (id_rdv, id_p) FROM stdin;
    public          postgres    false    210   lf                 0    16636    prise 
   TABLE DATA           -   COPY public.prise (id_rdv, id_m) FROM stdin;
    public          postgres    false    211   �f       {          0    16581    rdvous 
   TABLE DATA           J   COPY public.rdvous (nom_p, nom_m, id_rdv, lieu_rdv, date_rdv) FROM stdin;
    public          postgres    false    207   �f       �          0    16779    resultat 
   TABLE DATA           .   COPY public.resultat (id_c, id_o) FROM stdin;
    public          postgres    false    215   �f       �           0    0    seq_consultation    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.seq_consultation', 1, false);
          public          postgres    false    216            �           0    0    seq_incrementer    SEQUENCE SET     >   SELECT pg_catalog.setval('public.seq_incrementer', 21, true);
          public          postgres    false    202            �           0    0    seq_medecin    SEQUENCE SET     9   SELECT pg_catalog.setval('public.seq_medecin', 5, true);
          public          postgres    false    218            �           0    0    seq_ordonance    SEQUENCE SET     <   SELECT pg_catalog.setval('public.seq_ordonance', 1, false);
          public          postgres    false    219            �           0    0    seq_patient    SEQUENCE SET     :   SELECT pg_catalog.setval('public.seq_patient', 10, true);
          public          postgres    false    217            �           0    0 
   seq_rdvous    SEQUENCE SET     9   SELECT pg_catalog.setval('public.seq_rdvous', 1, false);
          public          postgres    false    220            �
           2606    16677    appartenir pk_appartenir 
   CONSTRAINT     ^   ALTER TABLE ONLY public.appartenir
    ADD CONSTRAINT pk_appartenir PRIMARY KEY (id_p, id_o);
 B   ALTER TABLE ONLY public.appartenir DROP CONSTRAINT pk_appartenir;
       public            postgres    false    212    212            �
           2606    16592    consultation pk_consultation 
   CONSTRAINT     \   ALTER TABLE ONLY public.consultation
    ADD CONSTRAINT pk_consultation PRIMARY KEY (id_c);
 F   ALTER TABLE ONLY public.consultation DROP CONSTRAINT pk_consultation;
       public            postgres    false    208            �
           2606    16597    consulter pk_consulter 
   CONSTRAINT     b   ALTER TABLE ONLY public.consulter
    ADD CONSTRAINT pk_consulter PRIMARY KEY (id_p, id_c, id_m);
 @   ALTER TABLE ONLY public.consulter DROP CONSTRAINT pk_consulter;
       public            postgres    false    209    209    209            �
           2606    16719    contenir pk_contenir 
   CONSTRAINT     ]   ALTER TABLE ONLY public.contenir
    ADD CONSTRAINT pk_contenir PRIMARY KEY (id_o, nom_med);
 >   ALTER TABLE ONLY public.contenir DROP CONSTRAINT pk_contenir;
       public            postgres    false    213    213            �
           2606    16776    fournir pk_fournir 
   CONSTRAINT     X   ALTER TABLE ONLY public.fournir
    ADD CONSTRAINT pk_fournir PRIMARY KEY (id_m, id_o);
 <   ALTER TABLE ONLY public.fournir DROP CONSTRAINT pk_fournir;
       public            postgres    false    214    214            �
           2606    16568    medecin pk_medecin 
   CONSTRAINT     R   ALTER TABLE ONLY public.medecin
    ADD CONSTRAINT pk_medecin PRIMARY KEY (id_m);
 <   ALTER TABLE ONLY public.medecin DROP CONSTRAINT pk_medecin;
       public            postgres    false    204            �
           2606    16556    medicament pk_medicament 
   CONSTRAINT     [   ALTER TABLE ONLY public.medicament
    ADD CONSTRAINT pk_medicament PRIMARY KEY (nom_med);
 B   ALTER TABLE ONLY public.medicament DROP CONSTRAINT pk_medicament;
       public            postgres    false    203            �
           2606    16580    ordonnance pk_ordonnance 
   CONSTRAINT     X   ALTER TABLE ONLY public.ordonnance
    ADD CONSTRAINT pk_ordonnance PRIMARY KEY (id_o);
 B   ALTER TABLE ONLY public.ordonnance DROP CONSTRAINT pk_ordonnance;
       public            postgres    false    206            �
           2606    16574    patient pk_patient 
   CONSTRAINT     R   ALTER TABLE ONLY public.patient
    ADD CONSTRAINT pk_patient PRIMARY KEY (id_p);
 <   ALTER TABLE ONLY public.patient DROP CONSTRAINT pk_patient;
       public            postgres    false    205            �
           2606    16605    prendre pk_prendre 
   CONSTRAINT     Z   ALTER TABLE ONLY public.prendre
    ADD CONSTRAINT pk_prendre PRIMARY KEY (id_rdv, id_p);
 <   ALTER TABLE ONLY public.prendre DROP CONSTRAINT pk_prendre;
       public            postgres    false    210    210            �
           2606    16640    prise pk_prise 
   CONSTRAINT     V   ALTER TABLE ONLY public.prise
    ADD CONSTRAINT pk_prise PRIMARY KEY (id_rdv, id_m);
 8   ALTER TABLE ONLY public.prise DROP CONSTRAINT pk_prise;
       public            postgres    false    211    211            �
           2606    16586    rdvous pk_rdvous 
   CONSTRAINT     R   ALTER TABLE ONLY public.rdvous
    ADD CONSTRAINT pk_rdvous PRIMARY KEY (id_rdv);
 :   ALTER TABLE ONLY public.rdvous DROP CONSTRAINT pk_rdvous;
       public            postgres    false    207            �
           2606    16783    resultat pk_resultat 
   CONSTRAINT     Z   ALTER TABLE ONLY public.resultat
    ADD CONSTRAINT pk_resultat PRIMARY KEY (id_c, id_o);
 >   ALTER TABLE ONLY public.resultat DROP CONSTRAINT pk_resultat;
       public            postgres    false    215    215            �
           1259    16679    i_fk_appartenir_ordonnance    INDEX     Q   CREATE INDEX i_fk_appartenir_ordonnance ON public.appartenir USING btree (id_o);
 .   DROP INDEX public.i_fk_appartenir_ordonnance;
       public            postgres    false    212            �
           1259    16678    i_fk_appartenir_patient    INDEX     N   CREATE INDEX i_fk_appartenir_patient ON public.appartenir USING btree (id_p);
 +   DROP INDEX public.i_fk_appartenir_patient;
       public            postgres    false    212            �
           1259    16599    i_fk_consulter_consultation    INDEX     Q   CREATE INDEX i_fk_consulter_consultation ON public.consulter USING btree (id_c);
 /   DROP INDEX public.i_fk_consulter_consultation;
       public            postgres    false    209            �
           1259    16600    i_fk_consulter_medecin    INDEX     L   CREATE INDEX i_fk_consulter_medecin ON public.consulter USING btree (id_m);
 *   DROP INDEX public.i_fk_consulter_medecin;
       public            postgres    false    209            �
           1259    16598    i_fk_consulter_patient    INDEX     L   CREATE INDEX i_fk_consulter_patient ON public.consulter USING btree (id_p);
 *   DROP INDEX public.i_fk_consulter_patient;
       public            postgres    false    209            �
           1259    16721    i_fk_contenir_medicament    INDEX     P   CREATE INDEX i_fk_contenir_medicament ON public.contenir USING btree (nom_med);
 ,   DROP INDEX public.i_fk_contenir_medicament;
       public            postgres    false    213            �
           1259    16720    i_fk_contenir_ordonnance    INDEX     M   CREATE INDEX i_fk_contenir_ordonnance ON public.contenir USING btree (id_o);
 ,   DROP INDEX public.i_fk_contenir_ordonnance;
       public            postgres    false    213            �
           1259    16777    i_fk_fournir_medecin    INDEX     H   CREATE INDEX i_fk_fournir_medecin ON public.fournir USING btree (id_m);
 (   DROP INDEX public.i_fk_fournir_medecin;
       public            postgres    false    214            �
           1259    16778    i_fk_fournir_ordonnance    INDEX     K   CREATE INDEX i_fk_fournir_ordonnance ON public.fournir USING btree (id_o);
 +   DROP INDEX public.i_fk_fournir_ordonnance;
       public            postgres    false    214            �
           1259    16607    i_fk_prendre_patient    INDEX     H   CREATE INDEX i_fk_prendre_patient ON public.prendre USING btree (id_p);
 (   DROP INDEX public.i_fk_prendre_patient;
       public            postgres    false    210            �
           1259    16606    i_fk_prendre_rdvous    INDEX     I   CREATE INDEX i_fk_prendre_rdvous ON public.prendre USING btree (id_rdv);
 '   DROP INDEX public.i_fk_prendre_rdvous;
       public            postgres    false    210            �
           1259    16642    i_fk_prise_medecin    INDEX     D   CREATE INDEX i_fk_prise_medecin ON public.prise USING btree (id_m);
 &   DROP INDEX public.i_fk_prise_medecin;
       public            postgres    false    211            �
           1259    16641    i_fk_prise_rdvous    INDEX     E   CREATE INDEX i_fk_prise_rdvous ON public.prise USING btree (id_rdv);
 %   DROP INDEX public.i_fk_prise_rdvous;
       public            postgres    false    211            �
           1259    16784    i_fk_resultat_consultation    INDEX     O   CREATE INDEX i_fk_resultat_consultation ON public.resultat USING btree (id_c);
 .   DROP INDEX public.i_fk_resultat_consultation;
       public            postgres    false    215            �
           1259    16785    i_fk_resultat_ordonnance    INDEX     M   CREATE INDEX i_fk_resultat_ordonnance ON public.resultat USING btree (id_o);
 ,   DROP INDEX public.i_fk_resultat_ordonnance;
       public            postgres    false    215            �
           2606    16816 #   appartenir fk_appartenir_ordonnance    FK CONSTRAINT     �   ALTER TABLE ONLY public.appartenir
    ADD CONSTRAINT fk_appartenir_ordonnance FOREIGN KEY (id_o) REFERENCES public.ordonnance(id_o);
 M   ALTER TABLE ONLY public.appartenir DROP CONSTRAINT fk_appartenir_ordonnance;
       public          postgres    false    206    212    2759            �
           2606    16811     appartenir fk_appartenir_patient    FK CONSTRAINT     �   ALTER TABLE ONLY public.appartenir
    ADD CONSTRAINT fk_appartenir_patient FOREIGN KEY (id_p) REFERENCES public.patient(id_p);
 J   ALTER TABLE ONLY public.appartenir DROP CONSTRAINT fk_appartenir_patient;
       public          postgres    false    2757    205    212            �
           2606    16791 #   consulter fk_consulter_consultation    FK CONSTRAINT     �   ALTER TABLE ONLY public.consulter
    ADD CONSTRAINT fk_consulter_consultation FOREIGN KEY (id_c) REFERENCES public.consultation(id_c);
 M   ALTER TABLE ONLY public.consulter DROP CONSTRAINT fk_consulter_consultation;
       public          postgres    false    209    2763    208            �
           2606    16796    consulter fk_consulter_medecin    FK CONSTRAINT     ~   ALTER TABLE ONLY public.consulter
    ADD CONSTRAINT fk_consulter_medecin FOREIGN KEY (id_m) REFERENCES public.medecin(id_m);
 H   ALTER TABLE ONLY public.consulter DROP CONSTRAINT fk_consulter_medecin;
       public          postgres    false    2755    204    209            �
           2606    16786    consulter fk_consulter_patient    FK CONSTRAINT     ~   ALTER TABLE ONLY public.consulter
    ADD CONSTRAINT fk_consulter_patient FOREIGN KEY (id_p) REFERENCES public.patient(id_p);
 H   ALTER TABLE ONLY public.consulter DROP CONSTRAINT fk_consulter_patient;
       public          postgres    false    205    209    2757            �
           2606    16826    contenir fk_contenir_medicament    FK CONSTRAINT     �   ALTER TABLE ONLY public.contenir
    ADD CONSTRAINT fk_contenir_medicament FOREIGN KEY (nom_med) REFERENCES public.medicament(nom_med);
 I   ALTER TABLE ONLY public.contenir DROP CONSTRAINT fk_contenir_medicament;
       public          postgres    false    203    213    2753            �
           2606    16821    contenir fk_contenir_ordonnance    FK CONSTRAINT     �   ALTER TABLE ONLY public.contenir
    ADD CONSTRAINT fk_contenir_ordonnance FOREIGN KEY (id_o) REFERENCES public.ordonnance(id_o);
 I   ALTER TABLE ONLY public.contenir DROP CONSTRAINT fk_contenir_ordonnance;
       public          postgres    false    206    213    2759            �
           2606    16831    fournir fk_fournir_medecin    FK CONSTRAINT     z   ALTER TABLE ONLY public.fournir
    ADD CONSTRAINT fk_fournir_medecin FOREIGN KEY (id_m) REFERENCES public.medecin(id_m);
 D   ALTER TABLE ONLY public.fournir DROP CONSTRAINT fk_fournir_medecin;
       public          postgres    false    204    214    2755            �
           2606    16836    fournir fk_fournir_ordonnance    FK CONSTRAINT     �   ALTER TABLE ONLY public.fournir
    ADD CONSTRAINT fk_fournir_ordonnance FOREIGN KEY (id_o) REFERENCES public.ordonnance(id_o);
 G   ALTER TABLE ONLY public.fournir DROP CONSTRAINT fk_fournir_ordonnance;
       public          postgres    false    2759    206    214            �
           2606    16806    prendre fk_prendre_patient    FK CONSTRAINT     z   ALTER TABLE ONLY public.prendre
    ADD CONSTRAINT fk_prendre_patient FOREIGN KEY (id_p) REFERENCES public.patient(id_p);
 D   ALTER TABLE ONLY public.prendre DROP CONSTRAINT fk_prendre_patient;
       public          postgres    false    210    205    2757            �
           2606    16801    prendre fk_prendre_rdvous    FK CONSTRAINT     |   ALTER TABLE ONLY public.prendre
    ADD CONSTRAINT fk_prendre_rdvous FOREIGN KEY (id_rdv) REFERENCES public.rdvous(id_rdv);
 C   ALTER TABLE ONLY public.prendre DROP CONSTRAINT fk_prendre_rdvous;
       public          postgres    false    207    210    2761            �
           2606    16856    prise fk_prise_medecin    FK CONSTRAINT     v   ALTER TABLE ONLY public.prise
    ADD CONSTRAINT fk_prise_medecin FOREIGN KEY (id_m) REFERENCES public.medecin(id_m);
 @   ALTER TABLE ONLY public.prise DROP CONSTRAINT fk_prise_medecin;
       public          postgres    false    2755    211    204            �
           2606    16851    prise fk_prise_rdvous    FK CONSTRAINT     x   ALTER TABLE ONLY public.prise
    ADD CONSTRAINT fk_prise_rdvous FOREIGN KEY (id_rdv) REFERENCES public.rdvous(id_rdv);
 ?   ALTER TABLE ONLY public.prise DROP CONSTRAINT fk_prise_rdvous;
       public          postgres    false    2761    211    207            �
           2606    16841 !   resultat fk_resultat_consultation    FK CONSTRAINT     �   ALTER TABLE ONLY public.resultat
    ADD CONSTRAINT fk_resultat_consultation FOREIGN KEY (id_c) REFERENCES public.consultation(id_c);
 K   ALTER TABLE ONLY public.resultat DROP CONSTRAINT fk_resultat_consultation;
       public          postgres    false    2763    215    208            �
           2606    16846    resultat fk_resultat_ordonnance    FK CONSTRAINT     �   ALTER TABLE ONLY public.resultat
    ADD CONSTRAINT fk_resultat_ordonnance FOREIGN KEY (id_o) REFERENCES public.ordonnance(id_o);
 I   ALTER TABLE ONLY public.resultat DROP CONSTRAINT fk_resultat_ordonnance;
       public          postgres    false    2759    215    206            �      x������ � �      |   2  x����n�0�g�)�%�&m3fp�6��4�r�:��bW�T�O�K�%�$&���s�0�Xbt>� ��.����3Ȥ������h3۷�}�}�[���TrX�)t�哔�B�����cl8 K�J���>u�|��꣍�� &� Y�\������<��D-�a{�-EpP��x!N�� �%:��*�R()MN6QtOF���FvFkc���'����C������R����8Ts�Had�y�=8<M���G<�"�R�֓�B}�6�%%�j���\�O"���[�e8_�}�J��X�1�8��f֗      }      x������ � �      �      x������ � �      �      x������ � �      x   i   x��Q
�0C��S��I�A{�~�ǌB��fK���.z$�f}W��ʮǥ��m�W��__�k麝1�#cȓ�� ���7X��_�|�,�,��y�����X!�      w   �   x�]�A
�0E��)z�VK=@�M���m7S�u q¨ ��9G.V����ټ7��Pz׃!-R2��x'�(:������D��U"�Z�s�	��`�j�Y�q	#:��;�N=T���s�,�D:���a�΂	�_i��j��]��S�j�j���35�L�N��f�LV�K�i�'>�R�/Ou&      z   *   x�3�,LIL�4442�50"΂Ģ��Ԓ����=... �I	0      y   �   x�e�=
�0Fg��@�-��\�(��!��!V�}���H����w�G�J��I�:�%\ܶp'���wL�_�)�i��f�� 1��h�ܨ&������U����?ˈ7C��a8F�@sU��X�`����+".֝:T      ~      x������ � �            x������ � �      {      x������ � �      �      x������ � �     