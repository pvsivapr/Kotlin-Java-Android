package com.example.Data;

public class ListItemsData {

    public static NewsListModel[] GetNewsItems()
    {
        NewsListModel[] newsListModels = new NewsListModel[]{
                new NewsListModel(
                        "Coronavirus vaccine likely by September, says Pune's Serum Institute",
                        "Vaccine major Serum Institute of India today said it plans to start production of the COVID-19 vaccine developed by Oxford University in the next two to three weeks and hopes to bring it to the market by October if the human clinical trials are successful.\n" +
                        "\n" +
                        "The Pune-based company has partnered with Oxford University as one of the seven global institutions manufacturing the vaccine.",
                        "https://images.livemint.com/img/2020/04/26/600x338/2020-04-18T130612Z_1610015380_RC217G9CRQTV_RTRMADP_3_HEALTH-CORONAVIRUS-VACCINE-OXFORD_1587889926260_1587889948849.JPG",
                        NewsListModel.ImageType.FromURL),
                new NewsListModel("Covid-19: Pune's Serum Institute to ready 20-40m vaccine shots at Rs 1,000/dose by Sept-Oct",
                        "MUMBAI: Pune-based Serum Institute, credited with affordable and innovative therapies like pneumonia and dengue monoclonal vaccines, plans to price the proposed Covid vaccine at around Rs 1,000 per dose in India. Serum is one of the global manufacturers that is putting its weight behind an Oxford University-led consortium, which announced the start of human clinical trials on April 23 and is one of the first such projects to get underway globally. ",
                        "https://static.toiimg.com/thumb/msid-75396645,imgsize-147696,width-400,resizemode-4/75396645.jpg",
                        NewsListModel.ImageType.FromURL),
                new NewsListModel("Titles3", "Description3", "https://www.cleverfiles.com/howto/wp-content/uploads/2018/03/minion.jpg", NewsListModel.ImageType.FromURL),
                new NewsListModel("Titles4", "Description4", "minion", NewsListModel.ImageType.FromFileName),
                new NewsListModel("Titles5", "Description5", "images5", NewsListModel.ImageType.FromFileName)
        };
        return newsListModels;
    }
}
