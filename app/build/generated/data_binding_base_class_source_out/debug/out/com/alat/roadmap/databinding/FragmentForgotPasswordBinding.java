// Generated by view binder compiler. Do not edit!
package com.alat.roadmap.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.alat.roadmap.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentForgotPasswordBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final Button continueButton;

  @NonNull
  public final EditText etEmail;

  @NonNull
  public final TextView tvEmailLabel;

  @NonNull
  public final TextView tvLogin;

  @NonNull
  public final TextView tvResetLabel;

  private FragmentForgotPasswordBinding(@NonNull FrameLayout rootView,
      @NonNull Button continueButton, @NonNull EditText etEmail, @NonNull TextView tvEmailLabel,
      @NonNull TextView tvLogin, @NonNull TextView tvResetLabel) {
    this.rootView = rootView;
    this.continueButton = continueButton;
    this.etEmail = etEmail;
    this.tvEmailLabel = tvEmailLabel;
    this.tvLogin = tvLogin;
    this.tvResetLabel = tvResetLabel;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentForgotPasswordBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentForgotPasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_forgot_password, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentForgotPasswordBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.continueButton;
      Button continueButton = ViewBindings.findChildViewById(rootView, id);
      if (continueButton == null) {
        break missingId;
      }

      id = R.id.etEmail;
      EditText etEmail = ViewBindings.findChildViewById(rootView, id);
      if (etEmail == null) {
        break missingId;
      }

      id = R.id.tvEmailLabel;
      TextView tvEmailLabel = ViewBindings.findChildViewById(rootView, id);
      if (tvEmailLabel == null) {
        break missingId;
      }

      id = R.id.tvLogin;
      TextView tvLogin = ViewBindings.findChildViewById(rootView, id);
      if (tvLogin == null) {
        break missingId;
      }

      id = R.id.tvResetLabel;
      TextView tvResetLabel = ViewBindings.findChildViewById(rootView, id);
      if (tvResetLabel == null) {
        break missingId;
      }

      return new FragmentForgotPasswordBinding((FrameLayout) rootView, continueButton, etEmail,
          tvEmailLabel, tvLogin, tvResetLabel);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
