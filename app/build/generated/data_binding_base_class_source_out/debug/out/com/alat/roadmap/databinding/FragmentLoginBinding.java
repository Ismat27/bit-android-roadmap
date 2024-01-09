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

public final class FragmentLoginBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final EditText etEmail;

  @NonNull
  public final EditText etPassword;

  @NonNull
  public final Button loginButton;

  @NonNull
  public final TextView textView;

  @NonNull
  public final TextView tvEmailLabel;

  @NonNull
  public final TextView tvForgotPassword;

  @NonNull
  public final TextView tvPasswordLabel;

  private FragmentLoginBinding(@NonNull FrameLayout rootView, @NonNull EditText etEmail,
      @NonNull EditText etPassword, @NonNull Button loginButton, @NonNull TextView textView,
      @NonNull TextView tvEmailLabel, @NonNull TextView tvForgotPassword,
      @NonNull TextView tvPasswordLabel) {
    this.rootView = rootView;
    this.etEmail = etEmail;
    this.etPassword = etPassword;
    this.loginButton = loginButton;
    this.textView = textView;
    this.tvEmailLabel = tvEmailLabel;
    this.tvForgotPassword = tvForgotPassword;
    this.tvPasswordLabel = tvPasswordLabel;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.etEmail;
      EditText etEmail = ViewBindings.findChildViewById(rootView, id);
      if (etEmail == null) {
        break missingId;
      }

      id = R.id.etPassword;
      EditText etPassword = ViewBindings.findChildViewById(rootView, id);
      if (etPassword == null) {
        break missingId;
      }

      id = R.id.loginButton;
      Button loginButton = ViewBindings.findChildViewById(rootView, id);
      if (loginButton == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      id = R.id.tvEmailLabel;
      TextView tvEmailLabel = ViewBindings.findChildViewById(rootView, id);
      if (tvEmailLabel == null) {
        break missingId;
      }

      id = R.id.tvForgotPassword;
      TextView tvForgotPassword = ViewBindings.findChildViewById(rootView, id);
      if (tvForgotPassword == null) {
        break missingId;
      }

      id = R.id.tvPasswordLabel;
      TextView tvPasswordLabel = ViewBindings.findChildViewById(rootView, id);
      if (tvPasswordLabel == null) {
        break missingId;
      }

      return new FragmentLoginBinding((FrameLayout) rootView, etEmail, etPassword, loginButton,
          textView, tvEmailLabel, tvForgotPassword, tvPasswordLabel);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
