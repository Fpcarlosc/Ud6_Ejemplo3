# Ud6_Ejemplo3
_Ejemplo 3 de la Unidad 6._

Vamos a implementar una aplicación que incorpore en su actividad principal un _ViewPager_ de tal forma que podamos movernos por 
las diferentes pantallas de la aplicación deslizando la pantalla. Además, también añadiremos un _TabLayout_ para añadir pestañas.

Para ello tenemos que seguir los siguientes pasos:

## Paso 1: Creación del _activity_main.xml_

El primer paso será crear el _layout_ de la actividad principal que tendrá como elemento raíz un _LinearLayout_ y contendrá tanto 
al _TabLayout_ como al _ViewPager_.
```
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <com.google.android.material.tabs.TabLayout
        android:id="@+id/tabs"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

    <androidx.viewpager.widget.ViewPager
        android:id="@+id/viewpager"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>

</LinearLayout>
```
## Paso 2: Creación de los _Fragments_

Los tres _Fragments_ creados estarán prácticamente vacíos, solo mostrarán un texto por pantalla. La estructura será igual en los 
tres casos:

### _fragment_fragment1.xml_
```
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Fragment1">

    <TextView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:text="@string/fragment1" />

</FrameLayout>
```

### _Fragment1.java_
```
public class Fragment1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment1, container, false);
    }

}
```

## Paso 3: Creación de la clase _AdaperFragments_
Esta será la clase que gestione qué _Fragment_ mostrar. Para ello tiene que heredar de la clase _FragmentPagerAdapter_ y sobrescribir 
los métodos _getItem_ (para obtener el _Fragment_ a mostrar), _getCount_ (para obtener el número de elementos) y _getPageTitle_ (que devuelve 
el título de la pestaña).
```
public class AdapterFragments extends FragmentPagerAdapter {
    private Context contexto;

    public AdapterFragments(Context context, FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        contexto = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new Fragment1();
        } else if (position == 1) {
            return new Fragment2();
        } else {
            return new Fragment3();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return contexto.getString(R.string.fragment1);
        } else if (position == 1) {
            return contexto.getString(R.string.fragment2);
        } else {
            return contexto.getString(R.string.fragment3);
        }
    }
}
```
## Paso 4: Creación de la clase _MainActivity_

En ella asociaremos el adaptador al _ViewPager_ y éste al _TabLayout_.
```
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Buscamos el ViewPager y el TabLayout
        ViewPager viewPager = findViewById(R.id.viewpager);
        TabLayout tabLayout = findViewById(R.id.tabs);

        // Creamos y asignamos el adaptador de Fragments
        AdapterFragments adapter = new AdapterFragments(this, getSupportFragmentManager());

        viewPager.setAdapter(adapter);

        // Conectamos el ViewPager con el TabLayout
        tabLayout.setupWithViewPager(viewPager);
    }
}
```
