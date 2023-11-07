package com.example.lapmarket.frg;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lapmarket.R;
import com.example.lapmarket.adapter.PhotoAdapter;
import com.example.lapmarket.adapter.SanphamAdapter;
import com.example.lapmarket.dao.SanPhamDAO;
import com.example.lapmarket.model.photo;
import com.example.lapmarket.model.sanpham;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;


public class frg_trangchu extends Fragment {
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private PhotoAdapter photoAdapter;

    SanPhamDAO sanPhamDAO;
    ArrayList<sanpham> list;
    ArrayList<sanpham> list1;

    SanphamAdapter sanphamAdapter;
    RecyclerView recyclerSanpham;


    public frg_trangchu() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_frg_trangchu, container, false);

        recyclerSanpham = view.findViewById(R.id.recyclerView_Sanpham);
        SearchView searchView = view.findViewById(R.id.search_sanpham);

        viewPager = view.findViewById(R.id.viewPager);
        circleIndicator = view.findViewById(R.id.circleindicator);
        photoAdapter = new PhotoAdapter(getContext(), getListPhoto());
        viewPager.setAdapter(photoAdapter);
        circleIndicator.setViewPager(viewPager);
        photoAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());

        loadData();

        return view;
    }

    private List<photo> getListPhoto(){
        List<photo> list = new ArrayList<>();
        list.add(new photo(R.drawable.laptop0));
        list.add(new photo(R.drawable.laptop1));
        list.add(new photo(R.drawable.laptop2));
        list.add(new photo(R.drawable.laptop3));

        return list;
    }

    public void loadData(){
        sanPhamDAO = new SanPhamDAO(getContext());
        list = sanPhamDAO.selectSANPHAM();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerSanpham.setLayoutManager(linearLayoutManager);

        sanphamAdapter = new SanphamAdapter(getContext(), list, sanPhamDAO);
        recyclerSanpham.setAdapter(sanphamAdapter);
    }
}