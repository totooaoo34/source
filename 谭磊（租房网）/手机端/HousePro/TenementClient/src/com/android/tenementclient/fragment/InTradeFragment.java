package com.android.tenementclient.fragment;

import java.util.ArrayList;
import java.util.List;

import com.android.tenementclient.R;
import com.android.tenementclient.adapte.GuessMsgAdapte;
import com.android.tenementclient.entity.GuessMsg;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * @author Administrator 百科-Fragment
 * 
 */
public class InTradeFragment extends Fragment {

	ListView lv_top_line;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.activity_home, container, false);

		lv_top_line = (ListView) view.findViewById(R.id.lv_home_in);

		lv_top_line.setAdapter(new GuessMsgAdapte(getActivity(), guessMsgs()));
		return view;
	}

	int[] imgs = { R.drawable.intrade01, R.drawable.intrade02,
			R.drawable.intrade03, R.drawable.intrade04 };

	String[] title = { "四房五房低价大户型4600元起...", "不怕长沙出租车调价 公交地铁...",
			"低价和深值兼得 望城区买房赢...", "9折优惠嫌少 85折or.." };

	String[] content = { "除了价格、环境、交通等大因素外，户型无疑是购房者买房时要考虑...",
			"长沙出租车调价 2公里起步价由6元涨至8...", "刚需买房最看重的是什么？应该就是房价了吧，毕竟积蓄有限，这就是大大",
			"除了价格、环境、交通等大因素外，户型无疑是购房者买房时要考虑..." };

	public List<GuessMsg> guessMsgs() {
		List<GuessMsg> list = new ArrayList<GuessMsg>();
		for (int i = 0; i < imgs.length; i++) {
			GuessMsg msg = new GuessMsg();
			msg.setGuessImg(imgs[i]);
			msg.setGuessTitle(title[i]);
			msg.setGuessContent(content[i]);
			list.add(msg);
		}
		return list;
	}
}
