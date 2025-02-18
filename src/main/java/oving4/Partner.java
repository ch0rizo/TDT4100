package oving4;

public class Partner {
  private String name;
  private Partner partner;

  public Partner(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public Partner getPartner() {
    return partner;
  }

  public void setPartner(Partner partner) {
        if (this.partner != null) {
            this.partner.partner = null;
        }
        this.partner = partner;

        if (partner != null) {
            if (partner.partner != null) {
                partner.partner.partner = null;
            }
            partner.partner = this;
        }
    }



  // @Override
  // public String toString() {
  //   return name + " " + "Partner med: " + partner;
  // }

  public static void main(String[] args) {
    Partner p1 = new Partner("1");
    Partner p2 = new Partner("2");
    Partner p3 = new Partner("3");
    Partner p4 = new Partner("4");

    p1.setPartner(p2);
    p3.setPartner(p4);

    System.out.println(p2.getPartner().name);
    System.out.println(p4.getPartner().name);

    p4.setPartner(p1);

    System.out.println(Partner);
    //p1.setPartner(p2);

  }
}
