package com.nytimes.uiactivities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.nytimes.networking.NYItemsListModel
import com.nytimes.networking.NYTimesService
import com.example.nytimes.R
import com.nytimes.networking.NYItemsModel
import retrofit2.Call
import retrofit2.Response
import java.lang.Exception

class NYItemsListPageFragment : Fragment()
{
    private var nYItemsListPageViewModel: NYItemsListPageViewModel? = null
    private var swipeRefreshLayout: SwipeRefreshLayout? =null
    lateinit var navController: NavController
    private var title: TextView? = null
    var newsType: String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = Navigation.findNavController(view)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activity_nyitems_display_page, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        activity?.actionBar?.hide()
        super.onActivityCreated(savedInstanceState)
        nYItemsListPageViewModel = ViewModelProvider(this).get(NYItemsListPageViewModel::class.java)
        nYItemsListPageViewModel?.nyTimesItems?.observe(viewLifecycleOwner, androidx.lifecycle.Observer<NYItemsListModel>{
            println("data obtained")
            if(it !== null) {
                loadAdapter(it)
            }
            swipeRefreshLayout?.isRefreshing = false
        })
        nYItemsListPageViewModel?.nyTimesItemDetail?.observe(viewLifecycleOwner, androidx.lifecycle.Observer<NYItemsModel>{
            println("data obtained")
            if(it !== null) {
                try {
                    var nyItemBundle = Bundle().apply {
                        putString("title", it.title)
                        putString("byline", it.byline)
                        putString("url", it.url)
                    }
                    navController.navigate(R.id.action_NYItemsListPageFragment_to_NYItemDetailPageFragment2, nyItemBundle)
                }
                catch (ex: Exception)
                {
                    ex.printStackTrace()
                }
            }
        })
        loadViews()
    }

    private fun loadAdapter(nyItemsListModel: NYItemsListModel)
    {
        try {
            val nyTimesListRecyclerView = view?.findViewById<View>(R.id.nyitems_list_view) as RecyclerView
            val nyTimesItemsListPageAdaptor = NYItemsListPageAdapter(nyItemsListModel, nYItemsListPageViewModel!!)
            nyTimesListRecyclerView.setHasFixedSize(true)
            nyTimesListRecyclerView.layoutManager = LinearLayoutManager(activity)// as RecyclerView.LayoutManager?
            nyTimesListRecyclerView.adapter = nyTimesItemsListPageAdaptor
        }
        catch (ex: Exception)
        {
            ex.printStackTrace()
        }
    }

    fun loadViews()
    {
        try
        {
            swipeRefreshLayout = view?.findViewById<SwipeRefreshLayout>(R.id.nyitems_swipe_list_view)
            swipeRefreshLayout?.setOnRefreshListener {
                nYItemsListPageViewModel?.GetNYItems(newsType!!)
            }
            val menuHamburgerImageButton = view?.findViewById<ImageButton>(R.id.imagebutton_menu_hamburger)
            menuHamburgerImageButton?.setOnClickListener{
                onImageButtonTapped(it)
            }
            val menuHamburgerSearchButton = view?.findViewById<ImageButton>(R.id.imagebutton_search_icon)
            menuHamburgerSearchButton?.setOnClickListener{
                onImageButtonTapped(it)
            }
            val menuOptionsImageButton = view?.findViewById<ImageButton>(R.id.imagebutton_menu_vertical_icon)
            menuOptionsImageButton?.setOnClickListener{
                onImageButtonTapped(it)
            }
            loadDynamicData()
        }
        catch (ex: Exception)
        {
            ex.printStackTrace()
        }
    }

    fun onImageButtonTapped(view: View)
    {
        val imageButtonView = view as ImageButton
        try {
            when (imageButtonView.id) {
                (R.id.imagebutton_menu_hamburger) -> {
                    activity?.finish()
                }
                (R.id.imagebutton_search_icon) -> {
                    val text = "Functionality is under development"
                    val duration = Toast.LENGTH_SHORT
                    val toast = Toast.makeText(activity, text, duration)
                    toast.show()
                }
                (R.id.imagebutton_menu_vertical_icon) -> {
                    loadDynamicData()
                }
                else -> {
                }
            }
        }
        catch (ex: Exception)
        {
            println(ex)
        }
    }

    fun loadDynamicData()
    {
        swipeRefreshLayout?.isRefreshing = true
        var types: Array<String> = arrayOf("arts", "automobiles", "books", "business", "fashion", "food", "health", "home", "insider", "magazine", "movies", "nyregion", "obituaries", "opinion", "politics", "realestate", "science", "sports", "sundayreview", "technology", "theater", "t-magazine", "travel", "upshot", "us", "world")
        newsType = types.random()
        title = view?.findViewById<TextView>(R.id.nyitems_diaplay_page_title)
        title?.text = newsType
        nYItemsListPageViewModel?.GetNYItems(newsType!!)
    }
}

class NYItemsListPageViewModel : ViewModel()
{
    var nyTimesItems = MutableLiveData<NYItemsListModel>()
    var nyTimesItemDetail = MutableLiveData<NYItemsModel>()
    var buttonId = MutableLiveData<Int>()

    fun GetNYItems(newsType: String)
    {
        try {
            var callNYTimesService = NYTimesService.create().getNYArtsItems(newsType)
            callNYTimesService.enqueue(object : retrofit2.Callback<NYItemsListModel> {
                override fun onFailure(call: Call<NYItemsListModel>, t: Throwable) {
                    println("This is a failed service call ${t.message}")
                    callNYTimesService.cancel()
                    nyTimesItems.postValue(null)
                }

                override fun onResponse( call: Call<NYItemsListModel>, response: Response<NYItemsListModel>) {
                    var nyTimesResponse: NYItemsListModel? = response.body()
                    var nyTimesItemsList = nyTimesResponse
                    if (nyTimesItemsList != null) {
                        println("Data is loaded")
                        nyTimesItems.postValue(nyTimesItemsList)
                    } else {
                        println("ny Times: is null")
                    }
                    callNYTimesService.cancel()
                }
            })
        }
        catch(ex: Exception)
        {
            println(ex.stackTrace)
        }
    }

    fun OnForwardButtonClicked(item: NYItemsModel)
    {
        if(item != null)
        {
            nyTimesItemDetail.postValue(item)
        }
        else{
            println("item is null")
        }
    }
}
