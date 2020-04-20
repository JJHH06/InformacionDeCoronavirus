package com.example.informaciondecoronavirus.Activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.informaciondecoronavirus.Topic
import com.example.informaciondecoronavirus.R
import com.example.informaciondecoronavirus.databinding.ActivityInformationVirusBinding
//Jose Hurtarte 19707

class InformationVirus : AppCompatActivity() {

    private lateinit var binding: ActivityInformationVirusBinding //inicio el data binding

    private var topic = Topic(  //vacio los parametros del topic
        title = "",
        subtitle = "",
        description = ""
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_information_virus)
        binding.topic = this.topic //asosiacion del binding y variable local

        var option = intent.extras?.get("option") //intent de la clase anterior
        binding.commentButton.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            intent.putExtra("comentario",binding.commentSectionText.text.toString()) //manda el intent con el comentario hecho
            startActivity(intent)
        }

        

        //llena los datos con el databinding de datos dependiendo de la opcion
        if (option == 1){  //Opcion del virus
            binding.topic?.title = "SRAS-CoV-2"
            binding.topic?.subtitle = "Virus causante del COVID-19"
            binding.topic?.description = "Los virus tienen a menudo nombres distintos a los de las enfermedades que causan. Por ejemplo, VIH es el nombre del virus que causa el sida. Ocurre a menudo que la gente conoce el nombre de una enfermedad pero no el del virus que la causa.\n" +
                    "\n" +
                    "A la hora de poner nombre a los virus y a las enfermedades, existen diferentes procesos y finalidades.\n" +
                    "\n" +
                    "Los nombres de los virus se basan en su estructura genética, ya que la finalidad que se persigue es facilitar el desarrollo de pruebas diagnósticas, vacunas y medicamentos. Los encargados de realizar este trabajo son los virólogos y la comunidad científica en general, por lo que los virus son nombrados por el Comité Internacional de Taxonomía de los Virus (ICTV, por sus siglas en inglés).\n" +
                    "\n" +
                    "Los nombres de las enfermedades tienen por objeto facilitar el debate sobre la prevención, propagación, transmisibilidad, gravedad y tratamiento de las mismas. La función de la OMS consiste en la preparación y la respuesta ante las enfermedades humanas, por lo que es la encargada de dar el nombre oficial a las enfermedades en la Clasificación Internacional de Enfermedades (CIE).\n" +
                    "\n" +
                    "El 11 de febrero de 2020, el ICTV anunció que el nombre del nuevo virus sería «coronavirus de tipo 2 causante del síndrome respiratorio agudo severo (SRAS-CoV-2)». Se eligió este nombre porque el virus está genéticamente relacionado con el coronavirus responsable del brote de SRAS de 2003, aunque se trata de dos virus diferentes.\n" +
                    "\n" +
                    "El 11 de febrero de 2020, la OMS anunció que el nombre de esta nueva enfermedad sería «COVID-19», de acuerdo con las directrices elaboradas previamente en colaboración con la Organización Mundial de Sanidad Animal (OIE) y la Organización de las Naciones Unidas para la Alimentación y la Agricultura (FAO).\n" + "\nobtenido de: https://www.who.int/es/emergencies/diseases/novel-coronavirus-2019/technical-guidance/naming-the-coronavirus-disease-(covid-2019)-and-the-virus-that-causes-it"
        }
        else if (option == 2){ //Opcion de sintomas
            binding.topic?.title = "Sintomatologia"
            binding.topic?.subtitle = "¿Cuáles son los síntomas de la COVID-19?"
            binding.topic?.description = "Los síntomas más comunes de la COVID-19 son fiebre, cansancio y tos seca. Algunos pacientes pueden presentar dolores, congestión nasal, rinorrea, dolor de garganta o diarrea. Estos síntomas suelen ser leves y aparecen de forma gradual. Algunas personas se infectan pero no desarrollan ningún síntoma y no se encuentran mal. La mayoría de las personas (alrededor del 80%) se recupera de la enfermedad sin necesidad de realizar ningún tratamiento especial. Alrededor de 1 de cada 6 personas que contraen la COVID-19 desarrolla una enfermedad grave y tiene dificultad para respirar. Las personas mayores y las que padecen afecciones médicas subyacentes, como hipertensión arterial, problemas cardiacos o diabetes, tienen más probabilidades" +
                    " de desarrollar una enfermedad grave. En torno al 2% de las personas que han contraído la enfermedad han muerto. " +
                    "Las personas que tengan fiebre, tos y dificultad para respirar deb" +
                    "en buscar atención médica.\n" + "Una persona puede contraer la COVID-19 por contacto con otra que esté infectada por el virus. La enfermedad puede propagarse de persona a persona a través de las gotículas procedentes de la nariz o la boca que salen despedidas cuando una persona infectada tose o exhala. Estas gotículas caen sobre los objetos y superficies que rodean a la persona, de modo que otras personas pueden contraer la COVID-19 si tocan estos objetos o superficies y luego se tocan los ojos, la nariz o la boca. También pueden contagiarse si inhalan las gotículas que haya esparcido una persona con COVID-19 al toser o exhalar. Por eso es importante mantenerse a más de 1 metro (3 pies) de distancia de una persona que se encuentre enferma.\n" +
                    "\n" +
                    "La OMS está estudiando las investigaciones en curso sobre las formas de propagación de la COVID-19 y seguirá informando sobre los resultados act" +
                    "ualizados.\n" +"\nobtenido de: https://www.who.int/es/emergencies/diseases/novel-coronavirus-2019/advice-for-public/q-a-coronaviruses#:~:text=sintomas"

        }
        else{ //Opcion de indicaciones
            binding.topic?.title = "Proteccion"
            binding.topic?.subtitle = "¿Qué puedo hacer para protegerme y prevenir la propagación de la enfermedad?"
            binding.topic?.description = "Medidas de protección para todas las personas \n" +
                    "Manténgase al día de la información más reciente sobre el brote de COVID-19, a la que puede acceder en el sitio web de la OMS y a través de las autoridades de salud pública pertinentes a nivel nacional y local. Se han registrado casos en muchos países de todo el mundo, y en varios de ellos se han producido brotes. Las autoridades chinas y las de otros países han conseguido enlentecer o detener el avance de los brotes, pero la situación es impredecible y es necesario comprobar con regularidad las noticias más recientes.\n" +
                    "\n" +
                    "Hay varias precauciones que se pueden adoptar para reducir la probabilidad de contraer o de contagiar la COVID-19:\n" +
                    "\n" +
                    "Lávese las manos a fondo y con frecuencia usando un desinfectante a base de alcohol o con agua y jabón.\n" +
                    "¿Por qué? Lavarse las manos con agua y jabón o usando un desinfectante a base de alcohol mata los virus que pueda haber en sus manos.\n" +
                    "\n" +
                    "Mantenga una distancia mínima de 1 metro (3 pies) entre usted y cualquier persona que tosa o estornude.\n" +
                    "¿Por qué? Cuando alguien tose o estornuda, despide por la nariz o por la boca unas gotículas de líquido que pueden contener el virus. Si está demasiado cerca, puede respirar las gotículas y con ellas el virus de la COVID-19, si la persona que tose tiene la enfermedad.\n" +
                    "\n" +
                    "Evite tocarse los ojos, la nariz y la boca\n" +
                    "¿Por qué? Las manos tocan muchas superficies y pueden recoger virus. Una vez contaminadas, las manos pueden transferir el virus a los ojos, la nariz o la boca. Desde allí, el virus puede entrar en su cuerpo y causarle la enfermedad.\n" +
                    "\n" +
                    "Tanto usted como las personas que les rodean deben asegurarse de mantener una buena higiene de las vías respiratorias. Eso significa cubrirse la boca y la nariz con el codo doblado o con un pañuelo de papel al toser o estornudar. El pañuelo usado debe desecharse de inmediato.\n" +
                    "¿Por qué? Los virus se propagan a través de las gotículas. Al mantener una buena higiene respiratoria está protegiendo a las personas que le rodean de virus como los del resfriado, la gripe y la COVID-19.\n" +
                    "\n" +
                    "Permanezca en casa si no se encuentra bien. Si tiene fiebre, tos y dificultad para respirar, busque atención médica y llame con antelación. Siga las instrucciones de las autoridades sanitarias locales.\n" +
                    "¿Por qué? Las autoridades nacionales y locales dispondrán de la información más actualizada sobre la situación en su zona. Llamar con antelación permitirá que su dispensador de atención de salud le dirija rápidamente hacia el centro de salud adecuado. Esto también le protegerá a usted y ayudará a prevenir la propagación de virus y otras infecciones.\n" +
                    "\n" +
                    "Manténgase informado sobre las últimas novedades en relación con la COVID-19. Siga los consejos de su dispensador de atención de salud, de las autoridades sanitarias pertinentes a nivel nacional y local o de su empleador sobre la forma de protegerse a sí mismo y a los demás ante la COVID-19.\n" +
                    "¿Por qué? Las autoridades nacionales y locales dispondrán de la información más actualizada acerca de si la COVID-19 se está propagando en su zona. Son los interlocutores más indicados para dar consejos sobre lo que debe hacer la gente de su zona para protegerse.\n" +
                    "\n" +
                    "Consulte las noticias más recientes sobre las zonas de mayor peligro (es decir, las ciudades y lugares donde la enfermedad se está propagando más extensamente). Si le es posible, evite desplazarse a estas zonas, sobre todo si su edad es avanzada o tiene usted diabetes, cardiopatías o neumopatías.\n" +
                    "¿Por qué? Estas precauciones se deben adoptar en estas zonas porque la probabilidad de contraer la COVID-19 es más elevada.\n" +
                    "\n" +
                    "Medidas de protección para las personas que se encuentran en zonas donde se está propagando la COVID-19 o que las han visitado recientemente (en los últimos 14 días)\n" +
                    "\n" +
                    "Siga las orientaciones antes expuestas (Medidas de protección para todas las personas)\n" +
                    "Permanezca en casa si empieza a encontrarse mal, aunque se trate de síntomas leves como dolor de cabeza, fiebre ligera (37,3 oC o más) y rinorrea leve, hasta que se recupere. Si le resulta indispensable salir de casa o recibir una visita (por ejemplo, para conseguir alimentos), póngase una mascarilla para no infectar a otras personas.\n" +
                    "¿Por qué? Evitar los contactos con otras personas y las visitas a centros médicos permitirá que estos últimos funcionen con mayor eficacia y ayudará a protegerle a usted y a otras personas de posibles infecciones por el virus de la COVID-19 u otros.\n" +
                    "\n" +
                    "Si tiene fiebre, tos y dificultad para respirar, busque rápidamente asesoramiento médico, ya que podría deberse a una infección respiratoria u otra afección grave. Llame con antelación e informe a su dispensador de atención de salud sobre cualquier viaje que haya realizado recientemente o cualquier contacto que haya mantenido con viajeros.\n" +
                    "¿Por qué? Llamar con antelación permitirá que su dispensador de atención de salud le dirija rápidamente hacia el centro de salud adecuado. Esto ayudará también a prevenir la propagación de virus y otras infecciones.\n" +
                    "\n" +
                    "¿Qué probabilidades hay de que contraiga la COVID-19?\n" +
                    "El riesgo depende del lugar donde se encuentre usted y, más concretamente, de si se está produciendo un brote de COVID-19 en dicho lugar.\n" +
                    "\n" +
                    "Para la mayoría de las personas que se encuentran en la mayor parte de los lugares, el riesgo de contraer esta enfermedad continúa siendo bajo. Sin embargo, sabemos que hay algunos lugares (ciudades o zonas) donde se está propagando y donde el riesgo de contraerla es más elevado, tanto para las personas que viven en ellas como para las que las visitan. Los gobiernos y las autoridades sanitarias están actuando con determinación cada vez que se detecta un nuevo caso de COVID-19. Es importante que todos respetemos las restricciones relativas a los viajes, los desplazamientos y las concentraciones multitudinarias de personas aplicables a cada lugar en concreto. Si cooperamos con las medidas de lucha contra la enfermedad, reduciremos el riesgo que corremos cada" +
                    " uno de nosotros de contraerla o de propagarla.\n"+"\nobtenido de:https://www.who.int/es/emergencies/diseases/novel-coronavirus-2019/advice-for-public/q-a-coronaviruses#:~:text=sintomas"
        }
    }



}
