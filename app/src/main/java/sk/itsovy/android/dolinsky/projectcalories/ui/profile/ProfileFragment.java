package sk.itsovy.android.dolinsky.projectcalories.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import sk.itsovy.android.dolinsky.projectcalories.R;
import sk.itsovy.android.dolinsky.projectcalories.test.UserViewHolder;

public class ProfileFragment extends Fragment {

	private static final String TAG = "ProfileFragment";

	private UserViewHolder viewHolder;
	private ProfileViewModel profileViewModel;
	private TextInputEditText editWeight;
	private EditText editGoal;
	private TextInputEditText editHeight;


	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	public View onCreateView(@NonNull LayoutInflater inflater,
							 ViewGroup container, Bundle savedInstanceState) {
		profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);

		View root = inflater.inflate(R.layout.fragment_profile, container, false);

		editWeight = root.findViewById(R.id.textWeight);
		editHeight = root.findViewById(R.id.textHeight);

		showHeightFragment();

		profileViewModel.weight.observe(getViewLifecycleOwner(), integer -> {
			editWeight.setText(String.valueOf(integer));

		});

		showWeightFragment();
		profileViewModel.height.observe(getViewLifecycleOwner(), integer -> {
			editHeight.setText(String.valueOf(integer));
		});


		return root;
	}

	private void showWeightFragment() {
		editWeight.setOnClickListener(v -> {
			NavHostFragment navHostFragment = (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
			NavController navController = navHostFragment.getNavController();
			navController.navigate(R.id.actionGetWeight);
		});
	}

	private void showHeightFragment() {
		editHeight.setOnClickListener(v -> {
			NavHostFragment navHostFragment = (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
			NavController navController = navHostFragment.getNavController();
			navController.navigate(R.id.actionGetHeight);
		});

	}


}
