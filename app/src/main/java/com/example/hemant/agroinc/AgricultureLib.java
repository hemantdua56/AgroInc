package com.example.hemant.agroinc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class AgricultureLib extends AppCompatActivity {
    private ArrayList<SectionDataModel> allSampleData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agriculture_lib);

        allSampleData = new ArrayList<>();

        createDummyData();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(allSampleData, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
    }
    private void createDummyData() {

            ArrayList<SingleItemModel> singleItemModelPulses = new ArrayList<>();

            singleItemModelPulses.add(new SingleItemModel("gram", "6-9","Winter/Rainy Season","-","Used when nutrients are low","All Soil Types",R.drawable.gram));
            singleItemModelPulses.add(new SingleItemModel("red-gram", "5-7","-","30-35 C","moisture","All",R.drawable.redgram));
            singleItemModelPulses.add(new SingleItemModel("moong", "b","c","d","E","f6",R.drawable.album2));
            singleItemModelPulses.add(new SingleItemModel("masar", "b","c","d","E","f6",R.drawable.album2));
            singleItemModelPulses.add(new SingleItemModel("beans", "b","c","d","E","f6",R.drawable.album2));

            ArrayList<SingleItemModel> singleItemModelFruits = new ArrayList<>();
            singleItemModelFruits.add(new SingleItemModel("banana", "6-7.5","June-September","15-35 C","Nitrogen, Potassium, Phosphorous","Loamy Soil",R.drawable.bana));
            singleItemModelFruits.add(new SingleItemModel("tomatoh", "6-7","August~September","20-30 C","Potassium, Moisture","Sandy Loamy",R.drawable.tomato));
            singleItemModelFruits.add(new SingleItemModel("apple", "b","c","d","E","f6",R.drawable.album2));
            singleItemModelFruits.add(new SingleItemModel("orange", "b","c","d","E","f6",R.drawable.album2));
            singleItemModelFruits.add(new SingleItemModel("papaya", "6-7.5","c","d","E","f6",R.drawable.album2));

        ArrayList<SingleItemModel> singleItemModelCereals = new ArrayList<>();
        singleItemModelCereals.add(new SingleItemModel("wheath", "6-8","November~December","20-25 C","Nitrogen, Potassium, Phosphorous","Clay Loamy",R.drawable.wheat));
        singleItemModelCereals.add(new SingleItemModel("rice", "b","c","d","E","f6",R.drawable.album2));
        singleItemModelCereals.add(new SingleItemModel("maize", "b","c","d","E","f6",R.drawable.album2));
        singleItemModelCereals.add(new SingleItemModel("barley", "b","c","d","E","f6",R.drawable.album2));
        singleItemModelCereals.add(new SingleItemModel("millet", "6-7.5","c","d","E","f6",R.drawable.album2));

        ArrayList<SingleItemModel> singleItemModelVegetables = new ArrayList<>();
        singleItemModelVegetables.add(new SingleItemModel("peas", "6.5~7.5","November~Februray","13-18 C","Phosphorous, Potassium","-",R.drawable.peas));
        singleItemModelVegetables.add(new SingleItemModel("onionh", "6-7.5","November~December","15-25 C","Potassium, Moisture","light Soil",R.drawable.onion));
        singleItemModelVegetables.add(new SingleItemModel("potato", "5-6.5","October-November","15-25 C","Phosphorous, Potassium","All",R.drawable.potatoes));
        singleItemModelVegetables.add(new SingleItemModel("ladyfinger", "b","c","d","E","f6",R.drawable.album2));
        singleItemModelVegetables.add(new SingleItemModel("brinjal", "6-7.5","c","d","E","f6",R.drawable.album2));

        ArrayList<SingleItemModel> singleItemModelSpecies = new ArrayList<>();
        singleItemModelSpecies.add(new SingleItemModel("chilli", "6.5-7.5","Rainy~Summer Season","15-30 C","Balanced Nitrogen, Phosphorous, Potassium","Sandy or Light Loamy Soil",R.drawable.paprika));
        singleItemModelSpecies.add(new SingleItemModel("garlic", "6-8","October~November","25~35 C","Balanced Nitrogen, Phosphorous, Potassium + Moisture","light Moisturized Soil",R.drawable.garlic));
        singleItemModelSpecies.add(new SingleItemModel("ginger", "b","c","d","E","f6",R.drawable.album2));
        singleItemModelSpecies.add(new SingleItemModel("cinnamon", "b","c","d","E","f6",R.drawable.album2));
        singleItemModelSpecies.add(new SingleItemModel("turmeric", "6-7.5","c","d","E","f6",R.drawable.album2));

        ArrayList<SingleItemModel> singleItemModelFibre = new ArrayList<>();
        singleItemModelFibre.add(new SingleItemModel("cottonh", "-","-","-","Balanced Nitrogen, Phosphorous, Potassium","Well Drained and deep soil",R.drawable.cotton));
        singleItemModelFibre.add(new SingleItemModel("sugarcane", "6.5-7.5","June~August","24-30 C","Potassium, Moisture","Loamy",R.drawable.sugarcane));
        singleItemModelFibre.add(new SingleItemModel("jute", "b","c","d","E","f6",R.drawable.sugarcane));
        singleItemModelFibre.add(new SingleItemModel("tobacco", "b","c","d","E","f6",R.drawable.album2));
        singleItemModelFibre.add(new SingleItemModel("bamboo", "6-7.5","c","d","E","f6",R.drawable.album2));


        SectionDataModel [] dm= new SectionDataModel[6];

             dm[0]= new SectionDataModel("pulses",singleItemModelPulses);
            dm[1]=new SectionDataModel("fruits",singleItemModelFruits);
            dm[2]=new SectionDataModel("cereals",singleItemModelCereals);
            dm[3]=new SectionDataModel("vegetables",singleItemModelVegetables);
            dm[4]=new SectionDataModel("spices",singleItemModelSpecies);
            dm[5]=new SectionDataModel("fibre",singleItemModelFibre);

        allSampleData.add(dm[0]);
            allSampleData.add(dm[1]);
            allSampleData.add(dm[2]);
            allSampleData.add(dm[3]);
            allSampleData.add(dm[4]);
            allSampleData.add(dm[5]);


    }
}
