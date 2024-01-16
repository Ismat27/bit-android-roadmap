package com.alat.roadmap;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class LoginFragmentDirections {
  private LoginFragmentDirections() {
  }

  @NonNull
  public static ActionLoginFragmentToForgotPasswordFragment actionLoginFragmentToForgotPasswordFragment(
      @NonNull String email) {
    return new ActionLoginFragmentToForgotPasswordFragment(email);
  }

  @NonNull
  public static NavDirections actionLoginFragmentToPostFragment() {
    return new ActionOnlyNavDirections(R.id.action_loginFragment_to_postFragment);
  }

  @NonNull
  public static NavDirections actionLoginFragmentToTodoFragment() {
    return new ActionOnlyNavDirections(R.id.action_loginFragment_to_todoFragment);
  }

  public static class ActionLoginFragmentToForgotPasswordFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionLoginFragmentToForgotPasswordFragment(@NonNull String email) {
      if (email == null) {
        throw new IllegalArgumentException("Argument \"email\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("email", email);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionLoginFragmentToForgotPasswordFragment setEmail(@NonNull String email) {
      if (email == null) {
        throw new IllegalArgumentException("Argument \"email\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("email", email);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("email")) {
        String email = (String) arguments.get("email");
        __result.putString("email", email);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_loginFragment_to_forgotPasswordFragment;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getEmail() {
      return (String) arguments.get("email");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionLoginFragmentToForgotPasswordFragment that = (ActionLoginFragmentToForgotPasswordFragment) object;
      if (arguments.containsKey("email") != that.arguments.containsKey("email")) {
        return false;
      }
      if (getEmail() != null ? !getEmail().equals(that.getEmail()) : that.getEmail() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionLoginFragmentToForgotPasswordFragment(actionId=" + getActionId() + "){"
          + "email=" + getEmail()
          + "}";
    }
  }
}
