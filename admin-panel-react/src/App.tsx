
import { useMemo, useState } from "react";
import "./App.css";

import {
  LayoutDashboard,
  Users,
  UserRound,
  ShieldCheck,
  Flag,
  Bell,
  CreditCard,
  Crown,
  Settings,
} from "lucide-react";

type UserStatus = "Verified" | "Pending" | "Blocked";
type ReviewStatus = "Pending" | "Approved" | "Rejected";

type User = {
  id: number;
  name: string;
  email: string;
  gender: string;
  age: number;
  city: string;
  joined: string;
  status: UserStatus;
};

type VerificationRequest = {
  id: number;
  name: string;
  email: string;
  age: number;
  city: string;
  submitted: string;
  documentType: string;
  status: ReviewStatus;
};


type ReportStatus = "Open" | "Resolved" | "Dismissed";

type SafetyReport = {
  id: number;
  reporter: string;
  reportedUser: string;
  reportedEmail: string;
  reason: string;
  details: string;
  date: string;
  status: ReportStatus;
};

type AdminNotification = {
  id: number;
  title: string;
  message: string;
  audience: string;
  createdAt: string;
  status: "Sent" | "Draft";
};

type SubscriptionPlan = {
  id: number;
  name: string;
  price: number;
  duration: number;
  description: string;
  features: string;
  active: boolean;
};

const initialSubscriptionPlans: SubscriptionPlan[] = [
  {
    id: 1,
    name: "Free",
    price: 0,
    duration: 30,
    description: "Get started with Milan",
    features: "Basic profile, limited interests",
    active: true,
  },
  {
    id: 2,
    name: "Premium",
    price: 999,
    duration: 90,
    description: "More ways to find a match",
    features: "More interests, shortlist, contact access",
    active: true,
  },
  {
    id: 3,
    name: "Elite",
    price: 1999,
    duration: 180,
    description: "An enhanced matchmaking experience",
    features: "Premium features, profile boost",
    active: true,
  },
];

const initialNotifications: AdminNotification[] = [
  {
    id: 4001,
    title: "Welcome to Milan",
    message: "Welcome to our matrimonial community. Complete your profile to get started.",
    audience: "All Members",
    createdAt: "15 Oct 2026",
    status: "Sent",
  },
  {
    id: 4002,
    title: "Complete Your Verification",
    message: "Verify your profile to help build trust with other members.",
    audience: "Pending Verification",
    createdAt: "14 Oct 2026",
    status: "Sent",
  },
  {
    id: 4003,
    title: "Scheduled Maintenance",
    message: "We are planning improvements to the Milan experience.",
    audience: "All Members",
    createdAt: "15 Oct 2026",
    status: "Draft",
  },
];

const initialReports: SafetyReport[] = [
  {
    id: 3001,
    reporter: "Neha Sharma",
    reportedUser: "Arjun Malhotra",
    reportedEmail: "arjun@example.com",
    reason: "Fake profile",
    details: "The reporter suspects the profile information may not be genuine.",
    date: "15 Oct 2026",
    status: "Open",
  },
  {
    id: 3002,
    reporter: "Kavya Singh",
    reportedUser: "Rohan Mehta",
    reportedEmail: "rohan@example.com",
    reason: "Inappropriate messages",
    details: "The reporter requests a review of unwanted messages.",
    date: "14 Oct 2026",
    status: "Open",
  },
  {
    id: 3003,
    reporter: "Aditi Verma",
    reportedUser: "Aarav Sharma",
    reportedEmail: "aarav@example.com",
    reason: "Suspicious activity",
    details: "The reporter requests a review of suspicious activity.",
    date: "13 Oct 2026",
    status: "Resolved",
  },
  {
    id: 3004,
    reporter: "Megha Kapoor",
    reportedUser: "Dev Khanna",
    reportedEmail: "dev@example.com",
    reason: "Harassment",
    details: "The reporter requests a review of a potentially abusive interaction.",
    date: "12 Oct 2026",
    status: "Open",
  },
];


const initialUsers: User[] = [
  { id: 1001, name: "Aarav Sharma", email: "aarav@example.com", gender: "Male", age: 27, city: "Delhi", joined: "12 Oct 2026", status: "Verified" },
  { id: 1002, name: "Ananya Verma", email: "ananya@example.com", gender: "Female", age: 25, city: "Mumbai", joined: "11 Oct 2026", status: "Pending" },
  { id: 1003, name: "Rohan Mehta", email: "rohan@example.com", gender: "Male", age: 29, city: "Jaipur", joined: "10 Oct 2026", status: "Verified" },
  { id: 1004, name: "Priya Kapoor", email: "priya@example.com", gender: "Female", age: 26, city: "Chandigarh", joined: "09 Oct 2026", status: "Pending" },
  { id: 1005, name: "Arjun Malhotra", email: "arjun@example.com", gender: "Male", age: 30, city: "Pune", joined: "08 Oct 2026", status: "Blocked" },
  { id: 1006, name: "Meera Gupta", email: "meera@example.com", gender: "Female", age: 24, city: "Bengaluru", joined: "07 Oct 2026", status: "Verified" },
];

const initialRequests: VerificationRequest[] = [
  { id: 2001, name: "Ananya Verma", email: "ananya@example.com", age: 25, city: "Mumbai", submitted: "15 Oct 2026", documentType: "Government ID", status: "Pending" },
  { id: 2002, name: "Priya Kapoor", email: "priya@example.com", age: 26, city: "Chandigarh", submitted: "14 Oct 2026", documentType: "Government ID", status: "Pending" },
  { id: 2003, name: "Kabir Singh", email: "kabir@example.com", age: 28, city: "Lucknow", submitted: "13 Oct 2026", documentType: "Selfie review", status: "Pending" },
  { id: 2004, name: "Isha Malhotra", email: "isha@example.com", age: 27, city: "Gurugram", submitted: "12 Oct 2026", documentType: "Government ID", status: "Approved" },
  { id: 2005, name: "Dev Khanna", email: "dev@example.com", age: 31, city: "Hyderabad", submitted: "11 Oct 2026", documentType: "Selfie review", status: "Rejected" },
];

const menuItems = [
  { name: "Dashboard", icon: LayoutDashboard },
  { name: "User Management", icon: Users },
  { name: "Profile Management", icon: UserRound },
  { name: "Verification", icon: ShieldCheck },
  { name: "Reports & Safety", icon: Flag },
  { name: "Notifications", icon: Bell },
  { name: "Subscriptions", icon: CreditCard },
  { name: "Membership Management", icon: Crown },
  { name: "Admin Profile", icon: UserRound },
  { name: "Settings", icon: Settings },
];

type MembershipStatus = "Active" | "Expired" | "Cancelled";
type MembershipPlan = "Free" | "Premium" | "Elite";

type MemberSubscription = {
  id: number;
  name: string;
  email: string;
  plan: MembershipPlan;
  startDate: string;
  expiryDate: string;
  status: MembershipStatus;
};

const initialMemberships: MemberSubscription[] = [
  {
    id: 5001,
    name: "Neha Sharma",
    email: "neha@example.com",
    plan: "Premium",
    startDate: "01 Oct 2026",
    expiryDate: "30 Dec 2026",
    status: "Active",
  },
  {
    id: 5002,
    name: "Aarav Mehta",
    email: "aarav@example.com",
    plan: "Free",
    startDate: "10 Oct 2026",
    expiryDate: "09 Nov 2026",
    status: "Active",
  },
  {
    id: 5003,
    name: "Kavya Singh",
    email: "kavya@example.com",
    plan: "Elite",
    startDate: "01 Apr 2026",
    expiryDate: "30 Sep 2026",
    status: "Expired",
  },
  {
    id: 5004,
    name: "Rohan Kapoor",
    email: "rohan@example.com",
    plan: "Premium",
    startDate: "15 Sep 2026",
    expiryDate: "15 Dec 2026",
    status: "Cancelled",
  },
  {
    id: 5005,
    name: "Aditi Verma",
    email: "aditi@example.com",
    plan: "Free",
    startDate: "12 Oct 2026",
    expiryDate: "11 Nov 2026",
    status: "Active",
  },
];

function App() {
  const [page, setPage] = useState("Verification");
  const [users, setUsers] = useState(initialUsers);
  const [requests, setRequests] = useState(initialRequests);

  const [reports, setReports] = useState(initialReports);
  const [reportFilter, setReportFilter] = useState("Open");

  const [notifications, setNotifications] = useState(initialNotifications);
  const [notificationTitle, setNotificationTitle] = useState("");
  const [notificationMessage, setNotificationMessage] = useState("");
  const [notificationAudience, setNotificationAudience] = useState("All Members");
  const [notificationFilter, setNotificationFilter] = useState("All");

  const [selectedReport, setSelectedReport] =
    useState<SafetyReport | null>(null);

  const [search, setSearch] = useState("");
  const [userFilter, setUserFilter] = useState("All");
  const [reviewFilter, setReviewFilter] = useState("Pending");
  const [selectedUser, setSelectedUser] = useState<User | null>(null);
  const [selectedRequest, setSelectedRequest] = useState<VerificationRequest | null>(null);
  const [notice, setNotice] = useState("");

  const filteredUsers = useMemo(
    () => users.filter((user) => {
      const query = `${user.name} ${user.email} ${user.city} ${user.id}`.toLowerCase();
      return query.includes(search.toLowerCase()) &&
        (userFilter === "All" || user.status === userFilter);
    }),
    [users, search, userFilter]
  );

  const filteredRequests = useMemo(
    () => requests.filter((request) => {
      const query = `${request.name} ${request.email} ${request.city} ${request.id}`.toLowerCase();
      return query.includes(search.toLowerCase()) &&
        (reviewFilter === "All" || request.status === reviewFilter);
    }),
    [requests, search, reviewFilter]
  );


const filteredReports = useMemo(
  () =>
    reports.filter((report) => {
      const query =
        `${report.id} ${report.reporter} ${report.reportedUser} ${report.reason} ${report.reportedEmail}`
          .toLowerCase();

      return (
        query.includes(search.toLowerCase()) &&
        (reportFilter === "All" || report.status === reportFilter)
      );
    }),
  [reports, search, reportFilter]
);


  function updateUserStatus(id: number, status: UserStatus) {
    setUsers((current) =>
      current.map((user) => user.id === id ? { ...user, status } : user)
    );
    setSelectedUser((current) =>
      current?.id === id ? { ...current, status } : current
    );
    setNotice(`Member status changed to ${status}.`);
  }

  function reviewRequest(id: number, status: "Approved" | "Rejected") {
    const request = requests.find((item) => item.id === id);
    if (!request || request.status !== "Pending") return;

    setRequests((current) =>
      current.map((item) => item.id === id ? { ...item, status } : item)
    );

    setUsers((current) =>
      current.map((user) => user.email.toLowerCase() === request.email.toLowerCase()
        ? { ...user, status: status === "Approved" ? "Verified" : "Pending" }
        : user)
    );

    setSelectedRequest({ ...request, status });
    setNotice(`${request.name}'s request was ${status.toLowerCase()}.`);
  }



function updateReportStatus(id: number, status: ReportStatus) {
  setReports((current) =>
    current.map((report) =>
      report.id === id ? { ...report, status } : report
    )
  );

  setSelectedReport((current) =>
    current?.id === id ? { ...current, status } : current
  );

  setNotice(`Report #${id} marked as ${status.toLowerCase()}.`);
}

function blockReportedUser(email: string) {
  const user = users.find(
    (item) => item.email.toLowerCase() === email.toLowerCase()
  );

  if (!user) {
    setNotice(
      "This demo user is not in the member directory. No account was changed."
    );
    return;
  }

  updateUserStatus(user.id, "Blocked");
  updateReportStatus(
    selectedReport!.id,
    "Resolved"
  );
}


function createNotification() {
  if (!notificationTitle.trim() || !notificationMessage.trim()) {
    setNotice("Please enter both a notification title and message.");
    return;
  }

  const newNotification: AdminNotification = {
    id: Date.now(),
    title: notificationTitle.trim(),
    message: notificationMessage.trim(),
    audience: notificationAudience,
    createdAt: new Date().toLocaleDateString("en-GB", {
      day: "2-digit",
      month: "short",
      year: "numeric",
    }),
    status: "Draft",
  };

  setNotifications((current) => [newNotification, ...current]);
  setNotificationTitle("");
  setNotificationMessage("");
  setNotice("Notification created as a draft.");
}

function updateNotificationStatus(
  id: number,
  status: "Sent" | "Draft"
) {
  setNotifications((current) =>
    current.map((item) =>
      item.id === id ? { ...item, status } : item
    )
  );

  setNotice(
    status === "Sent"
      ? "Demo notification marked as sent."
      : "Notification moved to draft."
  );
}

function deleteNotification(id: number) {
  setNotifications((current) =>
    current.filter((item) => item.id !== id)
  );

  setNotice("Notification deleted from demo data.");
}

  return (
    <div className="layout">
      <aside className="sidebar">
        <div className="brand">
          <span className="brand-icon">♥</span>
          <span>Milan<span className="brand-light"> Admin</span></span>
        </div>

        <p className="menu-label">MAIN MENU</p>
        <nav className="menu">

{menuItems.map((item) => {
  const Icon = item.icon;

  return (
    <button
      key={item.name}
      className={`menu-item ${page === item.name ? "active" : ""}`}
      onClick={() => setPage(item.name)}
      type="button"
    >
      <Icon size={18} strokeWidth={1.8} />
      <span>{item.name}</span>
    </button>
  );
})}

        </nav>

        <div className="sidebar-bottom">
          <div className="admin-avatar">A</div>
          <div><strong>Admin User</strong><small>Super Administrator</small></div>
        </div>
      </aside>

      <main className="main">
        <header className="topbar">
          <div>
            <span className="breadcrumb">Milan / Admin</span>
            <h1>{page}</h1>
          </div>
          <div className="topbar-right">
            <span className="admin-status">● Admin online</span>
            <div className="top-avatar">A</div>
          </div>
        </header>

        {notice && (
          <div className="notice" role="status">
            {notice}
            <button onClick={() => setNotice("")} aria-label="Dismiss">×</button>
          </div>
        )}

        {page === "Verification" && (
          <>
            <section className="welcome">
              <div>
                <h2>Profile Verification</h2>
                <p>Review member verification requests and record your decision.</p>
              </div>
              <span className="date-label">Review queue</span>
            </section>

            <section className="stats">
              <Stat title="Total Requests" value={requests.length} icon="▤" />
              <Stat title="Awaiting Review" value={requests.filter((r) => r.status === "Pending").length} icon="◷" />
              <Stat title="Approved" value={requests.filter((r) => r.status === "Approved").length} icon="✓" />
              <Stat title="Rejected" value={requests.filter((r) => r.status === "Rejected").length} icon="×" />
            </section>

            <section className="panel users-panel">
              <div className="panel-heading">
                <div>
                  <h3>Verification Queue</h3>
                  <p>Open a request to review its submitted information.</p>
                </div>
                <span className="total-badge">{filteredRequests.length} requests</span>
              </div>

              <div className="user-controls">
                <input
                  className="search-input"
                  value={search}
                  onChange={(event) => setSearch(event.target.value)}
                  placeholder="Search name, email or city..."
                  aria-label="Search verification requests"
                />
                <select
                  className="filter-select"
                  value={reviewFilter}
                  onChange={(event) => setReviewFilter(event.target.value)}
                  aria-label="Filter verification status"
                >
                  <option value="Pending">Pending review</option>
                  <option value="Approved">Approved</option>
                  <option value="Rejected">Rejected</option>
                  <option value="All">All statuses</option>
                </select>
              </div>

              <div className="table-wrap">
                <table>
                  <thead>
                    <tr>
                      <th>MEMBER</th>
                      <th>REQUEST ID</th>
                      <th>DOCUMENT TYPE</th>
                      <th>SUBMITTED</th>
                      <th>STATUS</th>
                      <th>ACTION</th>
                    </tr>
                  </thead>
                  <tbody>
                    {filteredRequests.map((request) => (
                      <tr key={request.id}>
                        <td>
                          <div className="member-cell">
                            <div className="member-avatar">{request.name.charAt(0)}</div>
                            <div><strong>{request.name}</strong><small>{request.email}</small></div>
                          </div>
                        </td>
                        <td>VER-{request.id}</td>
                        <td>{request.documentType}</td>
                        <td>{request.submitted}</td>
                        <td><span className={`status ${request.status.toLowerCase()}`}>{request.status}</span></td>
                        <td>
                          <button className="view-button" onClick={() => setSelectedRequest(request)}>
                            Review
                          </button>
                        </td>
                      </tr>
                    ))}
                    {filteredRequests.length === 0 && (
                      <tr><td colSpan={6} className="empty-state">No requests found for this search or status.</td></tr>
                    )}
                  </tbody>
                </table>
              </div>
            </section>

            <p className="demo-note">
              Demo mode: document references are placeholders. No real identity documents are stored or verified.
            </p>
          </>
        )}

        {page === "User Management" && (
          <>
            <section className="welcome">
              <div><h2>Manage Members</h2><p>Search, inspect, and manage Milan member accounts.</p></div>
              <span className="date-label">Member directory</span>
            </section>
            <section className="stats">
              <Stat title="Total Users" value={users.length} icon="♙" />
              <Stat title="Verified Profiles" value={users.filter((u) => u.status === "Verified").length} icon="✓" />
              <Stat title="Pending Verification" value={users.filter((u) => u.status === "Pending").length} icon="◷" />
              <Stat title="Blocked Accounts" value={users.filter((u) => u.status === "Blocked").length} icon="⊘" />
            </section>
            <section className="panel users-panel">
              <div className="panel-heading">
                <div><h3>All Members</h3><p>Demo profiles for testing admin actions.</p></div>
                <span className="total-badge">{filteredUsers.length} members</span>
              </div>
              <div className="user-controls">
                <input className="search-input" value={search} onChange={(event) => setSearch(event.target.value)} placeholder="Search name, email, city or ID..." aria-label="Search users" />
                <select className="filter-select" value={userFilter} onChange={(event) => setUserFilter(event.target.value)} aria-label="Filter users">
                  <option value="All">All statuses</option>
                  <option value="Verified">Verified</option>
                  <option value="Pending">Pending</option>
                  <option value="Blocked">Blocked</option>
                </select>
              </div>
              <div className="table-wrap">
                <table>
                  <thead><tr><th>MEMBER</th><th>PROFILE ID</th><th>LOCATION</th><th>JOINED</th><th>STATUS</th><th>ACTIONS</th></tr></thead>
                  <tbody>
                    {filteredUsers.map((user) => (
                      <tr key={user.id}>
                        <td><div className="member-cell"><div className="member-avatar">{user.name.charAt(0)}</div><div><strong>{user.name}</strong><small>{user.email}</small></div></div></td>
                        <td>MLN-{user.id}</td><td>{user.city}</td><td>{user.joined}</td>
                        <td><span className={`status ${user.status.toLowerCase()}`}>{user.status}</span></td>
                        <td><div className="action-buttons">
                          <button className="view-button" onClick={() => setSelectedUser(user)}>View</button>
                          {user.status === "Blocked"
                            ? <button className="unblock-button" onClick={() => updateUserStatus(user.id, "Pending")}>Unblock</button>
                            : <button className="block-button" onClick={() => updateUserStatus(user.id, "Blocked")}>Block</button>}
                        </div></td>
                      </tr>
                    ))}
                    {filteredUsers.length === 0 && <tr><td colSpan={6} className="empty-state">No members found.</td></tr>}
                  </tbody>
                </table>
              </div>
            </section>
          </>
        )}

        {page === "Dashboard" && (
          <>
            <section className="welcome">
              <div><h2>Welcome to Milan Admin</h2><p>A quick overview of member and verification activity.</p></div>
            </section>
            <section className="stats">
              <Stat title="Total Users" value={users.length} icon="♙" />
              <Stat title="Verified Profiles" value={users.filter((u) => u.status === "Verified").length} icon="✓" />
              <Stat title="Pending Requests" value={requests.filter((r) => r.status === "Pending").length} icon="◷" />
              <Stat title="Blocked Accounts" value={users.filter((u) => u.status === "Blocked").length} icon="⊘" />
            </section>
            <section className="panel placeholder">
              <h2>Admin overview</h2>
              <p>Use the sidebar to manage members and review profile verification requests.</p>
              <button className="primary-button" onClick={() => setPage("Verification")}>Review pending requests</button>
            </section>
          </>
        )}
    {page === "Profile Management" && (
      <ProfileManagementPage />
    )}


{page === "Reports & Safety" && (
  <>
    <section className="welcome">
      <div>
        <h2>Reports & Safety Center</h2>
        <p>Review member reports and manage community safety.</p>
      </div>
      <span className="date-label">Safety monitoring</span>
    </section>

    <section className="stats">
      <Stat
        title="Total Reports"
        value={reports.length}
        icon="⚑"
      />
      <Stat
        title="Open Reports"
        value={reports.filter((r) => r.status === "Open").length}
        icon="◷"
      />
      <Stat
        title="Resolved"
        value={reports.filter((r) => r.status === "Resolved").length}
        icon="✓"
      />
      <Stat
        title="Dismissed"
        value={reports.filter((r) => r.status === "Dismissed").length}
        icon="×"
      />
    </section>

    <section className="panel users-panel">
      <div className="panel-heading">
        <div>
          <h3>Member Reports</h3>
          <p>Search reports, inspect details and record an action.</p>
        </div>
        <span className="total-badge">
          {filteredReports.length} reports
        </span>
      </div>

      <div className="user-controls">
        <input
          className="search-input"
          value={search}
          onChange={(event) => setSearch(event.target.value)}
          placeholder="Search user, reason or report ID..."
          aria-label="Search reports"
        />

        <select
          className="filter-select"
          value={reportFilter}
          onChange={(event) => setReportFilter(event.target.value)}
          aria-label="Filter reports"
        >
          <option value="Open">Open reports</option>
          <option value="Resolved">Resolved</option>
          <option value="Dismissed">Dismissed</option>
          <option value="All">All statuses</option>
        </select>
      </div>

      <div className="table-wrap">
        <table>
          <thead>
            <tr>
              <th>REPORT ID</th>
              <th>REPORTED USER</th>
              <th>REASON</th>
              <th>DATE</th>
              <th>STATUS</th>
              <th>ACTION</th>
            </tr>
          </thead>

          <tbody>
            {filteredReports.map((report) => (
              <tr key={report.id}>
                <td>REP-{report.id}</td>
                <td>
                  <div className="member-cell">
                    <div className="member-avatar">
                      {report.reportedUser.charAt(0)}
                    </div>
                    <div>
                      <strong>{report.reportedUser}</strong>
                      <small>{report.reportedEmail}</small>
                    </div>
                  </div>
                </td>
                <td>{report.reason}</td>
                <td>{report.date}</td>
                <td>
                  <span className={`status ${report.status.toLowerCase()}`}>
                    {report.status}
                  </span>
                </td>
                <td>
                  <button
                    className="view-button"
                    onClick={() => setSelectedReport(report)}
                  >
                    View
                  </button>
                </td>
              </tr>
            ))}

            {filteredReports.length === 0 && (
              <tr>
                <td colSpan={6} className="empty-state">
                  No reports found.
                </td>
              </tr>
            )}
          </tbody>
        </table>
      </div>
    </section>

    <p className="demo-note">
      Demo mode: reports are fictional and changes are not saved
      to a database.
    </p>
  </>
)}


{page === "Notifications" && (
  <>
    <section className="welcome">
      <div>
        <h2>Notification Center</h2>
        <p>Create and manage announcements for Milan members.</p>
      </div>
      <span className="date-label">Communication</span>
    </section>

    <section className="stats">
      <Stat title="Total Notifications" value={notifications.length} icon="♧" />
      <Stat title="Sent (Demo)" value={notifications.filter((n) => n.status === "Sent").length} icon="✓" />
      <Stat title="Drafts" value={notifications.filter((n) => n.status === "Draft").length} icon="◷" />
      <Stat title="Audiences" value={new Set(notifications.map((n) => n.audience)).size} icon="♙" />
    </section>

    <section className="panel notification-form">
      <div className="panel-heading">
        <div>
          <h3>Create Notification</h3>
          <p>Write an announcement for a selected audience.</p>
        </div>
      </div>

      <form
        className="notification-fields"
        onSubmit={(event) => {
          event.preventDefault();
          createNotification();
        }}
      >
        <label>
          Notification title
          <input
            className="search-input"
            value={notificationTitle}
            onChange={(event) => setNotificationTitle(event.target.value)}
            placeholder="e.g. Complete your profile"
            maxLength={80}
            required
          />
        </label>

        <label>
          Message
          <textarea
            className="notification-textarea"
            value={notificationMessage}
            onChange={(event) => setNotificationMessage(event.target.value)}
            placeholder="Write your announcement..."
            rows={4}
            maxLength={500}
            required
          />
        </label>

        <label>
          Target audience
          <select
            className="filter-select"
            value={notificationAudience}
            onChange={(event) => setNotificationAudience(event.target.value)}
          >
            <option>All Members</option>
            <option>Verified Members</option>
            <option>Pending Verification</option>
          </select>
        </label>

        <button className="primary-button" type="submit">
          + Create Draft
        </button>
      </form>
    </section>

    <section className="panel users-panel">
      <div className="panel-heading">
        <div>
          <h3>All Notifications</h3>
          <p>Review drafts and demo sent statuses.</p>
        </div>
        <span className="total-badge">
          {notifications.filter((n) => notificationFilter === "All" || n.status === notificationFilter).length} notifications
        </span>
      </div>

      <div className="user-controls">
        <select
          className="filter-select"
          value={notificationFilter}
          onChange={(event) => setNotificationFilter(event.target.value)}
          aria-label="Filter notifications"
        >
          <option value="All">All statuses</option>
          <option value="Draft">Drafts</option>
          <option value="Sent">Sent (Demo)</option>
        </select>
      </div>

      <div className="table-wrap">
        <table>
          <thead>
            <tr>
              <th>TITLE & MESSAGE</th>
              <th>AUDIENCE</th>
              <th>CREATED</th>
              <th>STATUS</th>
              <th>ACTIONS</th>
            </tr>
          </thead>
          <tbody>
            {notifications
              .filter((item) => notificationFilter === "All" || item.status === notificationFilter)
              .map((item) => (
                <tr key={item.id}>
                  <td>
                    <div className="notification-copy">
                      <strong>{item.title}</strong>
                      <small>{item.message}</small>
                    </div>
                  </td>
                  <td>{item.audience}</td>
                  <td>{item.createdAt}</td>
                  <td>
                    <span className={`status ${item.status.toLowerCase()}`}>
                      {item.status === "Sent" ? "Sent (Demo)" : item.status}
                    </span>
                  </td>
                  <td>
                    <div className="action-buttons">
                      {item.status === "Draft" ? (
                        <button
                          className="approve-button"
                          onClick={() => updateNotificationStatus(item.id, "Sent")}
                        >
                          Mark Sent
                        </button>
                      ) : (
                        <button
                          className="secondary-button"
                          onClick={() => updateNotificationStatus(item.id, "Draft")}
                        >
                          Move to Draft
                        </button>
                      )}
                      <button
                        className="danger-button"
                        onClick={() => deleteNotification(item.id)}
                      >
                        Delete
                      </button>
                    </div>
                  </td>
                </tr>
              ))}

            {notifications.filter((item) => notificationFilter === "All" || item.status === notificationFilter).length === 0 && (
              <tr>
                <td colSpan={5} className="empty-state">
                  No notifications found.
                </td>
              </tr>
            )}
          </tbody>
        </table>
      </div>
    </section>

    <p className="demo-note">
      Demo mode: notifications are stored in page state only. No emails or push notifications are delivered.
    </p>
  </>
)}

{page === "Subscriptions" && <SubscriptionManagementPage />}

{page === "Membership Management" && (
  <MembershipManagementPage />
)}

{page === "Settings" && (
  <SettingsPage
    onSave={(message) => setNotice(message)}
  />
)}

{page === "Admin Profile" && <AdminProfilePage />}



{page !== "Dashboard" &&
  page !== "User Management" &&
  page !== "Verification" &&
  page !== "Reports & Safety" &&
  page != "Notifications" &&
  page != "Subscriptions" &&
  page != "Membership Management" &&
  page != "Profile Management" &&
  page != "Admin Profile" &&(
    <section className="panel placeholder">
      <div className="placeholder-icon">♥</div>
      <h2>{page}</h2>
      <p>This section is ready for the next stage of development.</p>
      <button
        className="primary-button"
        onClick={() => setPage("Verification")}
      >
        Go to Verification
      </button>
    </section>
  )}

      </main>

      {selectedRequest && (
        <div className="modal-backdrop" onClick={() => setSelectedRequest(null)}>
          <section className="user-modal" role="dialog" aria-modal="true" aria-labelledby="verification-title" onClick={(event) => event.stopPropagation()}>
            <button className="modal-close" onClick={() => setSelectedRequest(null)} aria-label="Close review">×</button>
            <div className="modal-avatar">{selectedRequest.name.charAt(0)}</div>
            <h2 id="verification-title">{selectedRequest.name}</h2>
            <p className="modal-subtitle">Verification request · VER-{selectedRequest.id}</p>
            <div className="review-callout">
              <strong>Review checklist</strong>
              <p>In a real deployment, compare the submitted document with the profile details and follow your verification policy. This demo does not display or validate an actual document.</p>
            </div>
            <div className="profile-details">
              <Detail label="Email" value={selectedRequest.email} />
              <Detail label="Age" value={`${selectedRequest.age} years`} />
              <Detail label="City" value={selectedRequest.city} />
              <Detail label="Submitted" value={selectedRequest.submitted} />
              <Detail label="Document type" value={selectedRequest.documentType} />
              <Detail label="Status" value={selectedRequest.status} />
            </div>
            {selectedRequest.status === "Pending" ? (
              <div className="modal-actions">
                <button className="approve-button" onClick={() => reviewRequest(selectedRequest.id, "Approved")}>✓ Approve</button>
                <button className="danger-button" onClick={() => reviewRequest(selectedRequest.id, "Rejected")}>✕ Reject</button>
                <button className="secondary-button" onClick={() => setSelectedRequest(null)}>Close</button>
              </div>
            ) : (
              <div className="modal-actions">
                <span className={`status ${selectedRequest.status.toLowerCase()}`}>Request {selectedRequest.status.toLowerCase()}</span>
                <button className="secondary-button" onClick={() => setSelectedRequest(null)}>Close</button>
              </div>
            )}
          </section>
        </div>
      )}


{selectedReport && (
  <div
    className="modal-backdrop"
    onClick={() => setSelectedReport(null)}
  >
    <section
      className="user-modal"
      role="dialog"
      aria-modal="true"
      aria-labelledby="report-title"
      onClick={(event) => event.stopPropagation()}
    >
      <button
        className="modal-close"
        onClick={() => setSelectedReport(null)}
        aria-label="Close report"
      >
        ×
      </button>

      <div className="modal-avatar">⚑</div>
      <h2 id="report-title">Report Details</h2>
      <p className="modal-subtitle">
        Report ID · REP-{selectedReport.id}
      </p>

      <div className="profile-details">
        <Detail label="Reported by" value={selectedReport.reporter} />
        <Detail label="Reported user" value={selectedReport.reportedUser} />
        <Detail label="Email" value={selectedReport.reportedEmail} />
        <Detail label="Reason" value={selectedReport.reason} />
        <Detail label="Date" value={selectedReport.date} />
        <Detail label="Status" value={selectedReport.status} />
      </div>

      <div className="review-callout">
        <strong>Report description</strong>
        <p>{selectedReport.details}</p>
      </div>

      <div className="modal-actions">
        {selectedReport.status === "Open" ? (
          <>
            <button
              className="approve-button"
              onClick={() =>
                updateReportStatus(selectedReport.id, "Resolved")
              }
            >
              ✓ Resolve
            </button>

            <button
              className="secondary-button"
              onClick={() =>
                updateReportStatus(selectedReport.id, "Dismissed")
              }
            >
              Dismiss
            </button>

            <button
              className="danger-button"
              onClick={() => blockReportedUser(selectedReport.reportedEmail)}
            >
              Block User
            </button>
          </>
        ) : (
          <span className={`status ${selectedReport.status.toLowerCase()}`}>
            {selectedReport.status}
          </span>
        )}

        <button
          className="secondary-button"
          onClick={() => setSelectedReport(null)}
        >
          Close
        </button>
      </div>
    </section>
  </div>
)}


      {selectedUser && (
        <div className="modal-backdrop" onClick={() => setSelectedUser(null)}>
          <section className="user-modal" role="dialog" aria-modal="true" aria-labelledby="profile-title" onClick={(event) => event.stopPropagation()}>
            <button className="modal-close" onClick={() => setSelectedUser(null)} aria-label="Close profile">×</button>
            <div className="modal-avatar">{selectedUser.name.charAt(0)}</div>
            <h2 id="profile-title">{selectedUser.name}</h2>
            <p className="modal-subtitle">Milan member · MLN-{selectedUser.id}</p>
            <div className="profile-details">
              <Detail label="Email" value={selectedUser.email} />
              <Detail label="Age" value={`${selectedUser.age} years`} />
              <Detail label="Gender" value={selectedUser.gender} />
              <Detail label="City" value={selectedUser.city} />
              <Detail label="Joined" value={selectedUser.joined} />
              <Detail label="Status" value={selectedUser.status} />
            </div>
            <div className="modal-actions">
              {selectedUser.status === "Blocked"
                ? <button className="approve-button" onClick={() => updateUserStatus(selectedUser.id, "Pending")}>Unblock Member</button>
                : <button className="danger-button" onClick={() => updateUserStatus(selectedUser.id, "Blocked")}>Block Member</button>}
              <button className="secondary-button" onClick={() => setSelectedUser(null)}>Close</button>
            </div>
          </section>
        </div>
      )}
    </div>
  );
}

function Stat({ title, value, icon }: { title: string; value: number; icon: string }) {
  return (
    <article className="stat-card">
      <div className="stat-top"><span>{title}</span><span className="stat-icon">{icon}</span></div>
      <strong>{value.toLocaleString()}</strong>
      <small>Demo data</small>
    </article>
  );
}

function Detail({ label, value }: { label: string; value: string }) {
  return <div className="detail-row"><span>{label}</span><strong>{value}</strong></div>;
}


function SettingsPage({
  onSave,
}: {
  onSave: (message: string) => void;
}) {
  const [appName, setAppName] = useState("Milan");
  const [supportEmail, setSupportEmail] = useState("support@milan.example");
  const [registrationAlerts, setRegistrationAlerts] = useState(true);
  const [verificationAlerts, setVerificationAlerts] = useState(true);
  const [reportAlerts, setReportAlerts] = useState(true);

  return (
    <section className="panel settings-panel">
      <div className="panel-heading">
        <div>
          <h3>General Settings</h3>
          <p>Manage basic information and admin preferences.</p>
        </div>
      </div>

      <form
        className="settings-form"
        onSubmit={(event) => {
          event.preventDefault();
          onSave("Settings saved for this demo session.");
        }}
      >
        <label>
          Application name
          <input
            className="search-input"
            value={appName}
            onChange={(event) => setAppName(event.target.value)}
            required
          />
        </label>

        <label>
          Support email
          <input
            className="search-input"
            type="email"
            value={supportEmail}
            onChange={(event) => setSupportEmail(event.target.value)}
            required
          />
        </label>

        <div className="settings-divider" />

        <h3>Admin Notifications</h3>
        <p className="settings-description">
          Choose which events the admin should monitor.
        </p>

        <label className="settings-toggle">
          <span>
            <strong>New registrations</strong>
            <small>Receive alerts for new member sign-ups.</small>
          </span>
          <input
            type="checkbox"
            checked={registrationAlerts}
            onChange={(event) => setRegistrationAlerts(event.target.checked)}
          />
        </label>

        <label className="settings-toggle">
          <span>
            <strong>Profile verification</strong>
            <small>Monitor pending verification requests.</small>
          </span>
          <input
            type="checkbox"
            checked={verificationAlerts}
            onChange={(event) => setVerificationAlerts(event.target.checked)}
          />
        </label>

        <label className="settings-toggle">
          <span>
            <strong>Safety reports</strong>
            <small>Monitor new member reports.</small>
          </span>
          <input
            type="checkbox"
            checked={reportAlerts}
            onChange={(event) => setReportAlerts(event.target.checked)}
          />
        </label>

        <button className="primary-button" type="submit">
          Save Settings
        </button>
      </form>
      <SecuritySettings />
    </section>
  );
}

function SubscriptionManagementPage() {
  const [plans, setPlans] = useState<SubscriptionPlan[]>(
    initialSubscriptionPlans
  );

  const [showForm, setShowForm] = useState(false);
  const [editingId, setEditingId] = useState<number | null>(null);

  const [name, setName] = useState("");
  const [price, setPrice] = useState("0");
  const [duration, setDuration] = useState("30");
  const [description, setDescription] = useState("");
  const [features, setFeatures] = useState("");

  const activePlans = plans.filter((plan) => plan.active).length;

  function resetForm() {
    setName("");
    setPrice("0");
    setDuration("30");
    setDescription("");
    setFeatures("");
    setEditingId(null);
    setShowForm(false);
  }

  function openAddForm() {
    resetForm();
    setShowForm(true);
  }

  function openEditForm(plan: SubscriptionPlan) {
    setEditingId(plan.id);
    setName(plan.name);
    setPrice(String(plan.price));
    setDuration(String(plan.duration));
    setDescription(plan.description);
    setFeatures(plan.features);
    setShowForm(true);
  }

  function savePlan(event: React.FormEvent<HTMLFormElement>) {
    event.preventDefault();

    const planData = {
      name: name.trim(),
      price: Number(price),
      duration: Number(duration),
      description: description.trim(),
      features: features.trim(),
    };

    if (editingId !== null) {
      setPlans((currentPlans) =>
        currentPlans.map((plan) =>
          plan.id === editingId ? { ...plan, ...planData } : plan
        )
      );
    } else {
      const newPlan: SubscriptionPlan = {
        id: Date.now(),
        ...planData,
        active: true,
      };

      setPlans((currentPlans) => [...currentPlans, newPlan]);
    }

    resetForm();
  }

  function togglePlan(id: number) {
    setPlans((currentPlans) =>
      currentPlans.map((plan) =>
        plan.id === id ? { ...plan, active: !plan.active } : plan
      )
    );
  }

  function deletePlan(id: number) {
    const confirmed = window.confirm(
      "Are you sure you want to delete this plan?"
    );

    if (confirmed) {
      setPlans((currentPlans) =>
        currentPlans.filter((plan) => plan.id !== id)
      );
    }
  }

  return (
    <div className="subscription-page">
      <div className="subscription-summary">
        <div className="subscription-stat">
          <span>Total Plans</span>
          <strong>{plans.length}</strong>
        </div>

        <div className="subscription-stat">
          <span>Active Plans</span>
          <strong>{activePlans}</strong>
        </div>

        <div className="subscription-stat">
          <span>Inactive Plans</span>
          <strong>{plans.length - activePlans}</strong>
        </div>
      </div>

      <section className="panel subscription-panel">
        <div className="panel-heading subscription-heading">
          <div>
            <h3>Subscription Plans</h3>
            <p>Manage Milan membership plans and their features.</p>
          </div>

          <button
            className="primary-button"
            onClick={openAddForm}
            type="button"
          >
            + Add Plan
          </button>
        </div>

        {showForm && (
          <form className="subscription-form" onSubmit={savePlan}>
            <h3>{editingId !== null ? "Edit Plan" : "Create New Plan"}</h3>

            <label>
              Plan Name
              <input
                className="search-input"
                value={name}
                onChange={(event) => setName(event.target.value)}
                placeholder="e.g. Premium"
                required
              />
            </label>

            <div className="subscription-form-row">
              <label>
                Price (₹)
                <input
                  className="search-input"
                  type="number"
                  min="0"
                  value={price}
                  onChange={(event) => setPrice(event.target.value)}
                  required
                />
              </label>

              <label>
                Duration (days)
                <input
                  className="search-input"
                  type="number"
                  min="1"
                  value={duration}
                  onChange={(event) => setDuration(event.target.value)}
                  required
                />
              </label>
            </div>

            <label>
              Description
              <input
                className="search-input"
                value={description}
                onChange={(event) => setDescription(event.target.value)}
                placeholder="Short plan description"
                required
              />
            </label>

            <label>
              Included Features
              <textarea
                className="search-input subscription-textarea"
                value={features}
                onChange={(event) => setFeatures(event.target.value)}
                placeholder="Describe features included in this plan"
                required
              />
            </label>

            <div className="subscription-form-actions">
              <button className="primary-button" type="submit">
                {editingId !== null ? "Save Changes" : "Create Plan"}
              </button>

              <button
                className="secondary-button"
                type="button"
                onClick={resetForm}
              >
                Cancel
              </button>
            </div>
          </form>
        )}

        <div className="subscription-plan-grid">
          {plans.map((plan) => (
            <article className="subscription-plan-card" key={plan.id}>
              <div className="subscription-plan-top">
                <h3>{plan.name}</h3>
                <span
                  className={`status ${
                    plan.active ? "active" : "inactive"
                  }`}
                >
                  {plan.active ? "Active" : "Inactive"}
                </span>
              </div>

              <div className="subscription-price">
                ₹{plan.price.toLocaleString("en-IN")}
                <span> / {plan.duration} days</span>
              </div>

              <p>{plan.description}</p>

              <div className="subscription-features">
                <strong>Included features</strong>
                <p>{plan.features}</p>
              </div>

              <div className="subscription-card-actions">
                <button
                  className="secondary-button"
                  type="button"
                  onClick={() => openEditForm(plan)}
                >
                  Edit
                </button>

                <button
                  className="secondary-button"
                  type="button"
                  onClick={() => togglePlan(plan.id)}
                >
                  {plan.active ? "Deactivate" : "Activate"}
                </button>

                <button
                  className="danger-button"
                  type="button"
                  onClick={() => deletePlan(plan.id)}
                >
                  Delete
                </button>
              </div>
            </article>
          ))}
        </div>

        {plans.length === 0 && (
          <div className="subscription-empty">
            No subscription plans yet. Click Add Plan to create one.
          </div>
        )}
      </section>
    </div>
  );
}

function MembershipManagementPage() {
  const [members, setMembers] =
    useState<MemberSubscription[]>(initialMemberships);

  const [search, setSearch] = useState("");
  const [planFilter, setPlanFilter] = useState("All");
  const [statusFilter, setStatusFilter] = useState("All");
  const [selectedMember, setSelectedMember] =
    useState<MemberSubscription | null>(null);

  const filteredMembers = members.filter((member) => {
    const matchesSearch =
      member.name.toLowerCase().includes(search.toLowerCase()) ||
      member.email.toLowerCase().includes(search.toLowerCase());

    const matchesPlan =
      planFilter === "All" || member.plan === planFilter;

    const matchesStatus =
      statusFilter === "All" || member.status === statusFilter;

    return matchesSearch && matchesPlan && matchesStatus;
  });

  function changePlan(id: number, plan: MembershipPlan) {
    setMembers((current) =>
      current.map((member) =>
        member.id === id ? { ...member, plan } : member
      )
    );
  }

  function changeStatus(id: number, status: MembershipStatus) {
    setMembers((current) =>
      current.map((member) =>
        member.id === id ? { ...member, status } : member
      )
    );

    setSelectedMember((current) =>
      current?.id === id ? { ...current, status } : current
    );
  }

  return (
    <div className="membership-page">
      <div className="subscription-summary">
        <div className="subscription-stat">
          <span>Total Members</span>
          <strong>{members.length}</strong>
        </div>

        <div className="subscription-stat">
          <span>Active Memberships</span>
          <strong>
            {members.filter((m) => m.status === "Active").length}
          </strong>
        </div>

        <div className="subscription-stat">
          <span>Expired Memberships</span>
          <strong>
            {members.filter((m) => m.status === "Expired").length}
          </strong>
        </div>
      </div>

      <section className="panel membership-panel">
        <div className="panel-heading">
          <div>
            <h3>Membership Management</h3>
            <p>View and manage member subscription details.</p>
          </div>
        </div>

        <div className="membership-filters">
          <input
            className="search-input"
            placeholder="Search by name or email..."
            value={search}
            onChange={(event) => setSearch(event.target.value)}
          />

          <select
            className="search-input"
            value={planFilter}
            onChange={(event) => setPlanFilter(event.target.value)}
          >
            <option value="All">All Plans</option>
            <option value="Free">Free</option>
            <option value="Premium">Premium</option>
            <option value="Elite">Elite</option>
          </select>

          <select
            className="search-input"
            value={statusFilter}
            onChange={(event) => setStatusFilter(event.target.value)}
          >
            <option value="All">All Statuses</option>
            <option value="Active">Active</option>
            <option value="Expired">Expired</option>
            <option value="Cancelled">Cancelled</option>
          </select>
        </div>

        <div className="table-container">
          <table>
            <thead>
              <tr>
                <th>Member</th>
                <th>Plan</th>
                <th>Start Date</th>
                <th>Expiry Date</th>
                <th>Status</th>
                <th>Actions</th>
              </tr>
            </thead>

            <tbody>
              {filteredMembers.map((member) => (
                <tr key={member.id}>
                  <td>
                    <strong>{member.name}</strong>
                    <br />
                    <span>{member.email}</span>
                  </td>

                  <td>
                    <select
                      className="membership-select"
                      value={member.plan}
                      onChange={(event) =>
                        changePlan(
                          member.id,
                          event.target.value as MembershipPlan
                        )
                      }
                    >
                      <option value="Free">Free</option>
                      <option value="Premium">Premium</option>
                      <option value="Elite">Elite</option>
                    </select>
                  </td>

                  <td>{member.startDate}</td>
                  <td>{member.expiryDate}</td>

                  <td>
                    <span
                      className={`status ${member.status.toLowerCase()}`}
                    >
                      {member.status}
                    </span>
                  </td>

                  <td>
                    <button
                      className="secondary-button"
                      onClick={() => setSelectedMember(member)}
                      type="button"
                    >
                      View
                    </button>
                  </td>
                </tr>
              ))}

              {filteredMembers.length === 0 && (
                <tr>
                  <td colSpan={6} className="membership-empty">
                    No memberships match your filters.
                  </td>
                </tr>
              )}
            </tbody>
          </table>
        </div>
      </section>

      {selectedMember && (
        <div className="modal-overlay">
          <section
            className="modal-content membership-modal"
            role="dialog"
            aria-modal="true"
            aria-labelledby="membership-modal-title"
          >
            <div className="panel-heading">
              <div>
                <h3 id="membership-modal-title">Member Details</h3>
                <p>{selectedMember.name}</p>
              </div>

              <button
                className="secondary-button"
                type="button"
                onClick={() => setSelectedMember(null)}
              >
                Close
              </button>
            </div>

            <p><strong>Email:</strong> {selectedMember.email}</p>
            <p><strong>Plan:</strong> {selectedMember.plan}</p>
            <p><strong>Start date:</strong> {selectedMember.startDate}</p>
            <p><strong>Expiry date:</strong> {selectedMember.expiryDate}</p>
            <p><strong>Status:</strong> {selectedMember.status}</p>

            <label className="membership-status-label">
              Update membership status
              <select
                className="search-input"
                value={selectedMember.status}
                onChange={(event) =>
                  changeStatus(
                    selectedMember.id,
                    event.target.value as MembershipStatus
                  )
                }
              >
                <option value="Active">Active</option>
                <option value="Expired">Expired</option>
                <option value="Cancelled">Cancelled</option>
              </select>
            </label>

            <p className="membership-note">
              Demo only: changing a plan or status does not charge a payment
              or update a real member account.
            </p>
          </section>
        </div>
      )}
    </div>
  );
}


type UserProfile = {
  id: number;
  name: string;
  email: string;
  gender: string;
  location: string;
  status: "Active" | "Inactive";
};

function ProfileManagementPage() {
  const [profiles, setProfiles] = useState<UserProfile[]>([
    {
      id: 1,
      name: "Neha Sharma",
      email: "neha@example.com",
      gender: "Female",
      location: "Delhi",
      status: "Active",
    },
    {
      id: 2,
      name: "Aarav Mehta",
      email: "aarav@example.com",
      gender: "Male",
      location: "Mumbai",
      status: "Active",
    },
    {
      id: 3,
      name: "Kavya Singh",
      email: "kavya@example.com",
      gender: "Female",
      location: "Jaipur",
      status: "Inactive",
    },
    {
      id: 4,
      name: "Rohan Kapoor",
      email: "rohan@example.com",
      gender: "Male",
      location: "Chandigarh",
      status: "Active",
    },
  ]);

  const [search, setSearch] = useState("");
  const [genderFilter, setGenderFilter] = useState("All");
  const [statusFilter, setStatusFilter] = useState("All");
  const [selectedProfile, setSelectedProfile] =
    useState<UserProfile | null>(null);

  const filteredProfiles = profiles.filter((profile) => {
    const matchesSearch =
      profile.name.toLowerCase().includes(search.toLowerCase()) ||
      profile.email.toLowerCase().includes(search.toLowerCase()) ||
      profile.location.toLowerCase().includes(search.toLowerCase());

    const matchesGender =
      genderFilter === "All" || profile.gender === genderFilter;

    const matchesStatus =
      statusFilter === "All" || profile.status === statusFilter;

    return matchesSearch && matchesGender && matchesStatus;
  });

  const toggleStatus = (id: number) => {
    setProfiles((currentProfiles) =>
      currentProfiles.map((profile) =>
        profile.id === id
          ? {
              ...profile,
              status:
                profile.status === "Active" ? "Inactive" : "Active",
            }
          : profile
      )
    );
  };

  return (
    <section className="panel">
      <div className="section-heading">
        <div>
          <h2>Profile Management</h2>
          <p>Review and manage matrimonial user profiles.</p>
        </div>
      </div>

      <div className="stats-grid">
        <div className="stat-card">
          <h3>Total Profiles</h3>
          <p>{profiles.length}</p>
        </div>
        <div className="stat-card">
          <h3>Active Profiles</h3>
          <p>{profiles.filter((p) => p.status === "Active").length}</p>
        </div>
        <div className="stat-card">
          <h3>Inactive Profiles</h3>
          <p>{profiles.filter((p) => p.status === "Inactive").length}</p>
        </div>
      </div>

      <div className="filters">
        <input
          type="text"
          placeholder="Search name, email or location..."
          value={search}
          onChange={(e) => setSearch(e.target.value)}
        />

        <select
          value={genderFilter}
          onChange={(e) => setGenderFilter(e.target.value)}
        >
          <option value="All">All Genders</option>
          <option value="Male">Male</option>
          <option value="Female">Female</option>
        </select>

        <select
          value={statusFilter}
          onChange={(e) => setStatusFilter(e.target.value)}
        >
          <option value="All">All Statuses</option>
          <option value="Active">Active</option>
          <option value="Inactive">Inactive</option>
        </select>
      </div>

      <div className="table-container">
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Email</th>
              <th>Gender</th>
              <th>Location</th>
              <th>Status</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {filteredProfiles.map((profile) => (
              <tr key={profile.id}>
                <td>{profile.id}</td>
                <td>{profile.name}</td>
                <td>{profile.email}</td>
                <td>{profile.gender}</td>
                <td>{profile.location}</td>
                <td>
                  <span
                    className={`status ${
                      profile.status === "Active" ? "active" : "inactive"
                    }`}
                  >
                    {profile.status}
                  </span>
                </td>
                <td>
                  <button
                    className="secondary-button"
                    onClick={() => setSelectedProfile(profile)}
                  >
                    View
                  </button>{" "}
                  <button
                    className="secondary-button"
                    onClick={() => toggleStatus(profile.id)}
                  >
                    {profile.status === "Active" ? "Deactivate" : "Activate"}
                  </button>
                </td>
              </tr>
            ))}
            {filteredProfiles.length === 0 && (
              <tr>
                <td colSpan={7}>No profiles found.</td>
              </tr>
            )}
          </tbody>
        </table>
      </div>

      {selectedProfile && (
        <div className="modal-overlay">
          <div className="modal-content">
            <h2>Profile Details</h2>
            <p><strong>Name:</strong> {selectedProfile.name}</p>
            <p><strong>Email:</strong> {selectedProfile.email}</p>
            <p><strong>Gender:</strong> {selectedProfile.gender}</p>
            <p><strong>Location:</strong> {selectedProfile.location}</p>
            <p><strong>Status:</strong> {selectedProfile.status}</p>
            <button
              className="secondary-button"
              onClick={() => setSelectedProfile(null)}
            >
              Close
            </button>
          </div>
        </div>
      )}
    </section>
  );
}


function SecuritySettings() {
  const [currentPassword, setCurrentPassword] = useState("");
  const [newPassword, setNewPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const [message, setMessage] = useState("");
  const [showPasswords, setShowPasswords] = useState(false);

  const handlePasswordUpdate = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    setMessage("");

    if (!currentPassword || !newPassword || !confirmPassword) {
      setMessage("Please fill in all password fields.");
      return;
    }

    if (newPassword.length < 8) {
      setMessage("New password must be at least 8 characters.");
      return;
    }

    if (newPassword !== confirmPassword) {
      setMessage("New passwords do not match.");
      return;
    }

    setMessage(
      "Form validated. Connect a backend to update your password securely."
    );
    setCurrentPassword("");
    setNewPassword("");
    setConfirmPassword("");
  };

  return (
    <section className="panel security-panel">
      <div className="section-heading">
        <div>
          <h2>Security Settings</h2>
          <p>Manage your administrator password.</p>
        </div>
      </div>

      <form onSubmit={handlePasswordUpdate} className="security-form">
        <label>
          Current Password
          <input
            type={showPasswords ? "text" : "password"}
            value={currentPassword}
            onChange={(e) => setCurrentPassword(e.target.value)}
            autoComplete="current-password"
            required
          />
        </label>

        <label>
          New Password
          <input
            type={showPasswords ? "text" : "password"}
            value={newPassword}
            onChange={(e) => setNewPassword(e.target.value)}
            autoComplete="new-password"
            minLength={8}
            required
          />
        </label>

        <label>
          Confirm New Password
          <input
            type={showPasswords ? "text" : "password"}
            value={confirmPassword}
            onChange={(e) => setConfirmPassword(e.target.value)}
            autoComplete="new-password"
            minLength={8}
            required
          />
        </label>

        <label className="show-password-option">
          <input
            type="checkbox"
            checked={showPasswords}
            onChange={(e) => setShowPasswords(e.target.checked)}
          />
          Show passwords
        </label>

        {message && <p role="status">{message}</p>}

        <button type="submit" className="primary-button">
          Update Password
        </button>
      </form>
    </section>
  );
}


function AdminProfilePage() {
  const [name, setName] = useState("Milan Administrator");
  const [email, setEmail] = useState("admin@milan.com");
  const [saved, setSaved] = useState(false);

  const handleSave = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    setSaved(true);
  };

  return (
    <section className="panel admin-profile-page">
      <div className="section-heading">
        <div>
          <h2>Admin Profile</h2>
          <p>Manage your administrator account information.</p>
        </div>
      </div>

      <div className="admin-profile-card">
        <div className="admin-avatar">
          {name.trim().charAt(0).toUpperCase() || "A"}
        </div>

        <div>
          <h3>{name || "Administrator"}</h3>
          <p>System Administrator</p>
          <span className="status active">Active Account</span>
        </div>
      </div>

      <form className="admin-profile-form" onSubmit={handleSave}>
        <label>
          Full Name
          <input
            value={name}
            onChange={(e) => {
              setName(e.target.value);
              setSaved(false);
            }}
            required
          />
        </label>

        <label>
          Email Address
          <input
            type="email"
            value={email}
            onChange={(e) => {
              setEmail(e.target.value);
              setSaved(false);
            }}
            required
          />
        </label>

        <label>
          Admin Role
          <input value="System Administrator" readOnly />
        </label>

        <button className="primary-button" type="submit">
          Save Changes
        </button>

        {saved && (
          <p role="status" className="profile-success">
            Profile changes saved for this session.
          </p>
        )}
      </form>
    </section>
  );
}


export default App;
